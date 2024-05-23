package com.weitest.wms.util;

import com.weitest.wms.config.Constants;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public final class FileUploadUtils {
    public static final String UPLOAD_API_PATH_PREFIX = "/upload";

    private static final int EXPIRATION_START_INDEX = (Constants.UPLOAD_ACCESS_SUFFIX_MAGIC + Constants.UPLOAD_ACCESS_PRIVATE_SUFFIX).length();
    private static final String DEFAULT_MIME_TYPE = "application/octet-stream";
    private static final MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();

    private static final List<String> DOWNLOAD_FILE_PATHS = new ArrayList<>(Arrays.asList("/upload/downloadFile", "/upload/downloadFiles"));

    public static final String ZIP_FILE_SUFFIX = ".zip";

    public static final int CONNECTION_TIME_OUT = 10 * 1000;

    public static final int READ_TIME_OUT = 10 * 1000;

    // 生成压缩包时, File.createTempFile 方法要求文件夹名字长度必须大于等于3
    public static final int FOLDER_NAME_MINI_LENGTH = 3;

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadUtils.class);

    public static String generateSavePath(String originPath, String basePath, String access, Double ttl,Boolean viaOriginUrl,Boolean hashFileName) throws NoSuchAlgorithmException {
        // 1. 添加时间戳避免重名
        String fileName = FilenameUtils.getName(originPath);
        String ext = FilenameUtils.getExtension(fileName);
        // 某些文件没有扩展名，不需要额外加 .
        ext = StringUtils.isEmpty(ext) ? "" : "." + ext;
        String filenameWithoutExt = FilenameUtils.removeExtension(fileName);
        String curTime = DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");

        // 2. 添加权限后缀
        String permissionSuffix = FileUploadUtils.getPathPermission(access, ttl);

        // 3. 添加CDN加速后缀
        String cdnSuffix = BooleanUtils.isTrue(viaOriginUrl)? "_ori" : "";

        // 4. 判断是否要随机散列文件名
        if(BooleanUtils.isTrue(hashFileName)){
            filenameWithoutExt = hashFileName(filenameWithoutExt);
        }

        String saveFilename = filenameWithoutExt + Constants.UPLOAD_ACCESS_SUFFIX_JOINER + curTime + cdnSuffix+ permissionSuffix + ext;

        // 5. 拼接上基础路径前缀
        return FilenameUtils.concat(FilenameUtils.concat(File.separator, basePath), saveFilename);
    }

    public static String hashFileName(String fileName) throws NoSuchAlgorithmException {

        int length = 32;

        // 生成随机字符串
        String uuid = UUID.randomUUID().toString();
        String randomString = uuid.replaceAll("-", "");

        // 计算文件名的散列值
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(fileName.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        // 截取散列值和随机字符串结合后的前32个字符
        String hashString = hexString.toString() + randomString;
        byte[] newHash = md.digest(hashString.getBytes(StandardCharsets.UTF_8));

        StringBuilder newHexString = new StringBuilder();
        for (byte b : newHash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) newHexString.append('0');
            newHexString.append(hex);
        }

        String newFileName = newHexString.toString().substring(0, length);

        return newFileName;
    }

    public static String convertToUnifiedPath(String url) {
        String path = url.replaceAll("\\\\", "/"); // 将Windows路径分隔符替换为Linux路径分隔符
        return path;
    }

    public static String getPathPermission(String access, Double ttl) {
        // 公开且不过期的文件不添加额外的后缀
        if (Constants.UPLOAD_ACCESS_PUBLIC.equalsIgnoreCase(access) && Constants.UPLOAD_ACCESS_NONE_EXPIRATION.equals(ttl)) {
            return "";
        }

        // 指定了文件访问权限信息，将在保存的文件名上添加权限后缀信息,生成规则: pms1/2[0时区到期时间戳]
        String accessPart = Constants.UPLOAD_ACCESS_PUBLIC.equalsIgnoreCase(access) ?
                Constants.UPLOAD_ACCESS_PUBLIC_SUFFIX : Constants.UPLOAD_ACCESS_PRIVATE_SUFFIX;
        String ttlPart = "";
        if (!Constants.UPLOAD_ACCESS_NONE_EXPIRATION.equals(ttl) && ttl > 0) {
            ttlPart = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("UTC"))
                    .plusMinutes((long) (ttl * 24 * 60)).toInstant().toEpochMilli() + "";
        }

        return Constants.UPLOAD_ACCESS_SUFFIX_JOINER + Constants.UPLOAD_ACCESS_SUFFIX_MAGIC + accessPart + ttlPart;
    }

    public static boolean isUploadApiPath(String apiPath, String method) {
        return "GET".equalsIgnoreCase(method) &&
                StringUtils.isNotBlank(apiPath) && ( apiPath.startsWith("/upload/") || apiPath.startsWith("/download/"));
    }

    public static boolean shouldAccessControl(String apiPath) {
        return StringUtils.isNotBlank(apiPath) && getPathPermissionSuffix(apiPath)
                .startsWith(Constants.UPLOAD_ACCESS_SUFFIX_MAGIC + Constants.UPLOAD_ACCESS_PRIVATE_SUFFIX);
    }

    public static boolean isPathExpiration(String apiPath) {
        String permissionSuffix = getPathPermissionSuffix(apiPath);
        if (StringUtils.isNotBlank(permissionSuffix) &&
                permissionSuffix.startsWith(Constants.UPLOAD_ACCESS_SUFFIX_MAGIC) &&
                permissionSuffix.length() > EXPIRATION_START_INDEX) {
            String expirationTimeStr = permissionSuffix.substring(EXPIRATION_START_INDEX);
            try {
                long expirationTime = Long.parseLong(expirationTimeStr);
                long now = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("UTC")).toInstant().toEpochMilli() ;
                return now >= expirationTime;
            } catch (NumberFormatException e) {
                LOGGER.info("parse upload path: {} expiration time error", apiPath);
            }
        }

        return false;
    }

    public static String getPathPermissionSuffix(String apiPath) {
        String fileName = FilenameUtils.getName(apiPath);
        String nameWithoutExt = FilenameUtils.removeExtension(fileName);
        String[] parts = nameWithoutExt.split(Constants.UPLOAD_ACCESS_SUFFIX_JOINER);
        String permissionPart = parts[parts.length - 1];

        return permissionPart;
    }

    public static String getFileMimeType(String fileName) {
        String mimeType = mimetypesFileTypeMap.getContentType(fileName.toLowerCase(Locale.ROOT));
        return StringUtils.defaultIfBlank(mimeType, DEFAULT_MIME_TYPE);
    }

    public static String getFileName(String url, String fileName) {
        // 处理文件名
        String originFileName = FilenameUtils.getName(url);
        // 文件后缀名
        String ext = FilenameUtils.getExtension(originFileName);
        if (StringUtils.isBlank(fileName)) {
            fileName = originFileName;
            // 处理仅有后缀名的文件，.log  --->  20221115151108735.log
            if (fileName.equals("." + ext)) {
                fileName = getCurrentTimestamp() + "." + ext;
            }
        } else if (StringUtils.isNotBlank(ext)) {
            fileName = fileName + "." + ext;
        }
        return fileName;
    }

    /** 获取多文件下载压缩包名字 **/
    public static String getCompressName(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            fileName = getCurrentTimestamp();
        } else if (fileName.length() < FOLDER_NAME_MINI_LENGTH) {
            fileName = fileName + "_" + getCurrentTimestamp();
        }
        return fileName;
    }

    /** 获取压缩包下的文件名称 **/
    public static String getCompressEntryName(String url, Map<String, Integer> compressEntryNameMap) {
        String compressEntryName = FilenameUtils.getName(url);
        // 处理重名文件
        if (compressEntryNameMap.containsKey(compressEntryName)) {
            compressEntryNameMap.put(compressEntryName, compressEntryNameMap.get(compressEntryName) + 1);
            String ext = FilenameUtils.getExtension(compressEntryName);
            // 某些文件没有扩展名，不需要额外加 .
            ext = StringUtils.isEmpty(ext) ? "" : "." + ext;
            String filenameWithoutExt = FilenameUtils.removeExtension(compressEntryName);
            compressEntryName = filenameWithoutExt + "-(" + compressEntryNameMap.get(compressEntryName) + ")" + ext;
        } else {
            compressEntryNameMap.put(compressEntryName, 1);
        }
        return compressEntryName;
    }

    public static String getCurrentTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
        Date date = new Date();
        return dateFormat.format(date);
    }


    /**
     根据 HttpServletRequest 对象和上传文件路径前缀获取上传文件的路径
     *
     @param request HttpServletRequest 对象
     @param uploadPrefix 上传文件路径前缀
     @return 上传文件的路径，如果获取失败则返回 null
     */
    //获取upload 后续路径
    public static String getUploadPath(HttpServletRequest request, String uploadPrefix) {
        StringBuffer requestURL = request.getRequestURL();
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        int index = requestURL.indexOf(requestURI);
        if (index != -1) {
            String prefix = requestURL.substring(0, index + contextPath.length());
            String path = requestURI.substring(contextPath.length());
            if (path.startsWith(uploadPrefix)) {
                return path.substring(uploadPrefix.length());
            }else if (path.equals(uploadPrefix)) {
                return "";
            }
        }
        return "";
    }

}