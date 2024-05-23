package com.weitest.wms.integration.http;

import org.springframework.http.HttpHeaders;
import com.weitest.wms.domain.http.HttpRequest;

import java.util.*;

/**
 * 对于request的抽象
 */
public class HttpRequestConvert {

    public static <T> HttpCallRequest convertToHttpCallRequest(HttpRequest<T> request) {
        final HttpCallRequest callRequest = new HttpCallRequest();
        callRequest.setUrl(request.requestURL);
        // header转换
        HttpHeaders httpHeaders = new HttpHeaders();
        for (Map.Entry<String, String> entry : request.headers.entrySet()) {
            httpHeaders.add(entry.getKey(), entry.getValue());
        }
        callRequest.setHeaders(httpHeaders);

        callRequest.setBody(request.body);

        boolean firstLine = true;
        for (Map.Entry<String, String> entry : request.queryParams.entrySet()) {
            if (null == entry) {
                continue;
            }
            if (firstLine) {
                callRequest.addQueryString(entry.getKey() + "=" + entry.getValue());
                firstLine = false;
                continue;
            }
            callRequest.addQueryString("&" + entry.getKey() + "=" + entry.getValue());
        }

        /**
         * path参数不能为空
         */
        for (Map.Entry<String, String> entry : request.pathParams.entrySet()) {
            callRequest.addPathParam(entry.getKey(), entry.getValue());
        }

        return callRequest;
    }
}
