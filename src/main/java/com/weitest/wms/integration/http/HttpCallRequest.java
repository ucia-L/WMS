package com.weitest.wms.integration.http;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import com.netease.cloud.RemoteCallRequest;
import com.weitest.wms.util.XmlUtils;

public class HttpCallRequest<T, R> implements RemoteCallRequest<T, R>{
    /**
     * 已拼接的url
     */
    private String url;
    /**
     * 请求头
     */
    private HttpHeaders headers = new HttpHeaders();
    /**
     * url中的参数
     */
    private List<String> queryString = new ArrayList<>();
    /**
     * 请求体
     */
    private T body;
    /**
     * 是否需要提交form表单
     */
    private Boolean hasFormDataHeader = Boolean.FALSE;
    /**
     * 是否是xml格式
     */
    private boolean hasXmlHeader;
    /**
     * 请求方式
     */
    private HttpMethod requestMethod;
    /**
     * 返回值类型
     */
    private Class<R> returnClazz;
    /**
     * 集合类型的返回值类型
     */
    private ParameterizedTypeReference<R> collectionReturnClazz;

    public HttpCallRequest<T, R> addHeader(final String key, final String value) {
        this.headers.add(key, value);
        return this;
    }

    public HttpCallRequest<T, R> addQueryString(final String queryString) {
        this.queryString.add(queryString);
        return this;
    }

    public HttpCallRequest<T, R> addPathParam(final String paramName, final String value) {
        this.url = this.url.replace("{" + paramName + "}", value);
        return this;
    }

    /**
     * 构建http请求体
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public HttpEntity buildHttpEntity() throws InvocationTargetException, IllegalAccessException {
        if (this.hasFormDataHeader) {
            return new HttpEntity(this.buildFormDataParam(), this.headers);
        } else if (this.hasXmlHeader) {
            return new HttpEntity<>(this.buildXmlDataParam(), this.headers);
        }
        return new HttpEntity(this.body, this.headers);
    }

    public Boolean getHasFormDataHeader() {
        return hasFormDataHeader;
    }

    public HttpCallRequest<T, R> setHasFormDataHeader(Boolean hasFormDataHeader) {
        this.hasFormDataHeader = hasFormDataHeader;
        return this;
    }

    public boolean isHasXmlHeader() {
        return hasXmlHeader;
    }

    public HttpCallRequest<T, R> setHasXmlHeader(boolean hasXmlHeader) {
        this.hasXmlHeader = hasXmlHeader;
        return this;
    }

    /**
     * build xml type param
     *
     * @return xml type param
     */
    private String buildXmlDataParam() {
        if (null == this.body) {
            return "";
        }
        Charset charset = XmlUtils.getXmlCharset(this.headers.getContentType());
        return XmlUtils.beanToXmlWithCharset(body, charset);
    }

    private MultiValueMap<String, Object> buildFormDataParam() throws InvocationTargetException, IllegalAccessException {
        if (null == this.body) {
            return new LinkedMultiValueMap<>();
        }
        MultiValueMap<String, Object> result = new LinkedMultiValueMap<>();
        Class<?> clazz = body.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (!method.getName().startsWith("get")) {
                continue;
            }
            String filedName = StringUtils.uncapitalize(method.getName().substring(method.getName().indexOf("get") + 3));
            result.add(filedName, method.invoke(body));
        }
        return result;
    }

    public String getUrl() {
        return url;
    }

    public HttpCallRequest<T, R> setUrl(String url) {
        this.url = url;
        return this;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public HttpCallRequest<T, R> setHeaders(HttpHeaders headers) {
        this.headers = headers;
        return this;
    }

    public List<String> getQueryString() {
        return queryString;
    }

    public HttpCallRequest<T, R> setQueryString(List<String> queryString) {
        this.queryString = queryString;
        return this;
    }

    public T getBody() {
        return body;
    }

    public HttpCallRequest<T, R> setBody(T body) {
        this.body = body;
        return this;
    }

    public HttpMethod getRequestMethod() {
        return requestMethod;
    }

    public HttpCallRequest<T, R> setRequestMethod(HttpMethod requestMethod) {
        this.requestMethod = requestMethod;
        return this;
    }

    public Class<R> getReturnClazz() {
        return returnClazz;
    }

    public HttpCallRequest<T, R> setReturnClazz(Class<R> returnClazz) {
        this.returnClazz = returnClazz;
        return this;
    }

    public ParameterizedTypeReference<R> getCollectionReturnClazz() {
        return collectionReturnClazz;
    }

    public HttpCallRequest<T, R> setCollectionReturnClazz(ParameterizedTypeReference<R> collectionReturnClazz) {
        this.collectionReturnClazz = collectionReturnClazz;
        return this;
    }
}
