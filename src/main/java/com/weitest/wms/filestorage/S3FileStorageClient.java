package com.weitest.wms.filestorage;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.event.ProgressEventType;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.AmazonS3URI;
import com.amazonaws.services.s3.model.*;
import com.weitest.wms.config.Constants;
import com.weitest.wms.domain.enumeration.ErrorCodeEnum;
import com.weitest.wms.exception.HttpCodeException;
import com.weitest.wms.util.FileUploadUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * s3对象存储文件系统实现
 *
 * @author gaowx
 * @date 2022-06-10 15:34
 */
@Component
public class S3FileStorageClient implements FileStorageClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(S3FileStorageClient.class);

    private static final String S3_TYPE = "s3";
    private static final String NOS_TYPE = "nos";

    private static final Long FILE_SIZE_THRESHOLD = 5L * 1024L * 1024L;

    private String address;
    private String accessKey;
    private String secretKey;
    private String bucket;

    private String storageType;

    private AmazonS3 s3Client;

    //cdn加速地址
    private String cdnAddress;

    @Value("${file.types}")
    private String fileTypes;


    @Override
    public String[] types() {
        return new String[] {S3_TYPE, NOS_TYPE};
    }

    @Override
    public String type() {
        return S3_TYPE;
    }

    @Override
    public void init(Map<String, String> config) {
        storageType = ObjectUtils.defaultIfNull(config.get(Constants.UPLOAD_CONFIG_KEY_FILE_STORAGE_TYPE), S3_TYPE);
        address = config.get(Constants.UPLOAD_CONFIG_KEY_S3_ADDRESS);
        accessKey = config.get(Constants.UPLOAD_CONFIG_KEY_S3_ACCESS_KEY);
        secretKey = config.get(Constants.UPLOAD_CONFIG_KEY_S3_SECRET_KEY);
        bucket = config.get(Constants.UPLOAD_CONFIG_KEY_S3_BUCKET);
        cdnAddress = config.get(Constants.UPLOAD_CONFIG_KEY_CDN_ADDRESS);

        if (!StringUtils.isEmpty(address)) {
            s3Client = newClient(address, accessKey, secretKey);
            LOGGER.info("{}文件系统client初始化完成，address: {}", storageType, address);
        } else if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("未配置{}文件服务信息，将无法上传到{}服务器", storageType, storageType);
        }

        if(StringUtils.isNotBlank(cdnAddress)){
            LOGGER.info("文件系统配置CDN地址，cdnAddress: {}", cdnAddress);
        }else {
            LOGGER.info("文件系统未配置CDN地址");
        }
    }

    private AmazonS3 newClient(String address, String accessKey, String secretKey) {
        AmazonS3 client = null;
        if (!StringUtils.isEmpty(accessKey) && !StringUtils.isEmpty(secretKey) && !StringUtils.isEmpty(address)) {
            AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

            client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider( credentials))
                    .withPathStyleAccessEnabled(S3_TYPE.equals(storageType) ? true : false)
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(address, null))
                    .withChunkedEncodingDisabled(true)
                    .build();
        }

        return client;
    }

    @Override
    public String upload(InputStream inputStream, String targetPath, Map<String, String> payloads) throws IOException {
        if (null == s3Client) {
            throw new HttpCodeException(HttpStatus.METHOD_NOT_ALLOWED.value(), ErrorCodeEnum.FILESYSTEM_NOT_SUPPORT.code);
        }

        String key =  formatPath(targetPath);
        //对上传key进行标准化
        key = formatUploadKey(key);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(FileUploadUtils.getFileMimeType(key));
        long contentLength = inputStream.available();
        if (contentLength > FILE_SIZE_THRESHOLD * 20) {
            LOGGER.info("big file use multipartUpload");
            multipartUpload(inputStream, key);
            LOGGER.info("big file upload success!");
        } else {
            // 存储S3对象
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, inputStream, metadata);
            putObjectRequest.getRequestClientOptions().setReadLimit(FILE_SIZE_THRESHOLD.intValue());
            s3Client.putObject(putObjectRequest);
        }

        return targetPath;
    }


    /**
     * 大文件分段上传
     * @param inputStream
     */
    private void multipartUpload(InputStream inputStream, String key) throws IOException {
        InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(bucket, key);
        initRequest.getRequestClientOptions().setReadLimit(FILE_SIZE_THRESHOLD.intValue());
        InitiateMultipartUploadResult initResponse = s3Client.initiateMultipartUpload(initRequest);
        // Upload the file parts.
        List<PartETag> partETags = new ArrayList<>();
        byte[] bytes = new byte[FILE_SIZE_THRESHOLD.intValue()];
        int read;
        int partIndex = 1;
        while ((read = inputStream.read(bytes)) > 0) {
            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes)) {
                // Create the request to upload a part.
                UploadPartRequest uploadRequest = new UploadPartRequest()
                        .withBucketName(bucket)
                        .withKey(key)
                        .withUploadId(initResponse.getUploadId())
                        .withPartNumber(partIndex++)
                        .withInputStream(byteArrayInputStream)
                        .withPartSize(read);

                UploadPartResult uploadResult = s3Client.uploadPart(uploadRequest);
                partETags.add(uploadResult.getPartETag());
            }
        }

        // Complete the multipart upload.
        CompleteMultipartUploadRequest compRequest = new CompleteMultipartUploadRequest(bucket, key,
                initResponse.getUploadId(), partETags);
        s3Client.completeMultipartUpload(compRequest);
    }

    @Override
    public void download(OutputStream outputStream, String targetPath, Map<String, String> payloads) throws IOException {
        if (null == s3Client) {
            throw new HttpCodeException(HttpStatus.METHOD_NOT_ALLOWED.value(), ErrorCodeEnum.FILESYSTEM_NOT_SUPPORT.code);
        }

        //开启源地址访问
        if (targetPath.contains("_ori")) {
            redirect(targetPath, cdnAddress);
            return;
        }
        try {
            S3Object s3Object = s3Client.getObject(bucket, formatPath(targetPath));
            //黑名单指定的文件类型不允许浏览器直接预览
            filterTargetFile(s3Object);

            //批量下载文件时, 不应该设置
            if (payloads.containsKey(FileStorageClient.SINGLE_DOWNLOAD) && Boolean.valueOf(payloads.get(FileStorageClient.SINGLE_DOWNLOAD))) {
                //兼容浏览器播放器需要文件大小, 不然无法播放
                this.addContentLength(s3Object.getObjectMetadata().getContentLength());
            }
            try (S3ObjectInputStream s3ObjectInputStream = s3Object.getObjectContent()) {
                IOUtils.copyLarge(s3ObjectInputStream, outputStream);
            }
        }catch (AmazonS3Exception e){
            if("NoSuchKey".equals(e.getErrorCode())){
                throw new HttpCodeException(String.format("文件不存在 NoSuchKey{%s}",targetPath));
            }else {
                throw new HttpCodeException(e.getErrorMessage());
            }
        }
    }

    /**
     重定向HTTP请求到另一个URL
     @param targetPath 目标路径
     @param cdnAddress CDN地址
     @throws IOException 如果发生IO异常
     */
    public void redirect(String targetPath, String cdnAddress) throws IOException {
        String locationUrl;
        if (StringUtils.isNotBlank(cdnAddress)) {
            locationUrl = getURL(targetPath, cdnAddress);
        } else {
            locationUrl = getS3Url(targetPath);
        }
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setStatus(HttpStatus.FOUND.value());
        URI locationUri = null;
        try {
            locationUri = new URI(null, null, locationUrl, null);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        String location = locationUri.toASCIIString();
        response.setHeader("Location", location);
    }

    /**
     获取S3对象存储中的目标路径的URL
     @param targetPath 目标路径
     @return S3中目标路径的URL
     @throws UnsupportedEncodingException 如果编码不受支持
     */
    private String getS3Url(String targetPath) throws UnsupportedEncodingException {
        URL url = s3Client.getUrl(bucket, targetPath);
        String host = url.getHost();
        String path = url.getPath();
        // s3Client方法会进行转义 所以需要反转义
        path = URLDecoder.decode(path, "UTF-8");
        // 过滤掉对于的 特殊字符
        return url.getProtocol() + "://"+ host + path.replaceAll("/{2,}", "/");
    }

    private String getURL(String targetPath, String cdnAddress) throws MalformedURLException, UnsupportedEncodingException {
        URL url;
        if (cdnAddress.startsWith("http://") || cdnAddress.startsWith("https://")) {
            url = new URL(cdnAddress + "/" + targetPath);
        } else {
            url = new URL("https://" + cdnAddress + "/" + targetPath);
            try {
                 url.openConnection().connect();
            } catch (IOException e) {
                 url = new URL("http://" + cdnAddress + "/" + targetPath);
            }
        }
        String host = url.getHost();
        String path = url.getPath();
        // s3Client方法会进行转义 所以需要反转义
        path = URLDecoder.decode(path, "UTF-8");
        return url.getProtocol() + "://"+ host + path.replaceAll("/{2,}", "/");
    }

    //输入是 文件对象 如果是S3 那就是S3Object
    @Override
    public void filterTargetFile(Object fileObject) {
        S3Object s3Object = (S3Object) fileObject;
        //过滤掉S3Object中的特殊字符
        //修改content-type,通过文件下载的方式，浏览器会根据content-type来决定是否直接打开文件 希望通过配置的方式
        String fileType = s3Object.getObjectMetadata().getContentType();
        if (fileType != null && (Arrays.asList(fileTypes.split(";"))).contains(fileType)) {
            HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;filename=" + s3Object.getKey());
        }
    }

    @Override
    public void delete(String targetPath, Map<String, String> payloads) throws IOException {
        if (null == s3Client) {
            throw new HttpCodeException(HttpStatus.METHOD_NOT_ALLOWED.value(), ErrorCodeEnum.FILESYSTEM_NOT_SUPPORT.code);
        }

        s3Client.deleteObject(bucket, formatPath(targetPath));
    }

    private String formatPath(String path) {
        /**
         * @since 非oss上传, 兼容历史数据(因为发了一版之后, 既有带/, 也有不带的)
         * 旧数据下载时, path一定带有/, 不带/的不需要拼接
         */
        if (StringUtils.isBlank(path)) {
            return path;
        }
        /**
         * 先判原本的path是否存在文件
         */
        if (this.s3Client.doesObjectExist(this.bucket, path)) {
            return path;
        } else {
            /**
             * 文件不存在, 则判断是否是以/开头
             */
            boolean startWithTag = path.startsWith("/");
            if (startWithTag) {
                /**
                 * 需要把/截取
                 */
                path = path.substring(1);
                return path;
            }
            /**
             * 需要拼接/
             */
            return FilenameUtils.concat(File.separator, path);
        }
    }

    //  1、为了兼容 Windos的 上传路径为 "\" 的情况，NOS 或者 S3 只认知 "/", 所以需要对windows进行转换
    //  2、key 是不允许出现 / 为前缀的，所以需要对key进行转换
    private String formatUploadKey(String key) {
        key = key.replace(File.separator,"/");
        if(key.startsWith("/")){
            key = key.substring(1);
        }
        return key;
    }

    private void addContentLength(final long contentLength) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        //非浏览器请求不设置
        if (null == response) {
            return;
        }
        response.setHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(contentLength));
    }
}
