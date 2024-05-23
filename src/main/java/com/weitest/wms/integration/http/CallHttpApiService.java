package com.weitest.wms.integration.http;

import com.weitest.wms.config.JacksonConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.ResponseEntity;
import com.weitest.wms.exception.HttpCodeException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import com.netease.cloud.RemoteCallApi;
import org.springframework.util.CollectionUtils;
import com.netease.cloud.RemoteCallRequest;
import com.netease.cloud.RemoteCallResponse;
import com.netease.cloud.RemoteCallApiClient;
import com.weitest.wms.util.XmlMessageConverter;
import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * http接口调用
 */
@RemoteCallApiClient
public class CallHttpApiService implements RemoteCallApi{

    private RestTemplate restTemplate;

    @PostConstruct
    public void init(){
        HttpComponentsClientRestfulHttpRequestFactory httpRequestFactory = new HttpComponentsClientRestfulHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(30000);
        httpRequestFactory.setConnectTimeout(30000);
        httpRequestFactory.setReadTimeout(30000);
        this.restTemplate = new RestTemplate(httpRequestFactory);
        // delete restTemplate`s xml converter,use custom xml convert
        this.restTemplate.getMessageConverters().removeIf(converter->(Objects.equals(MappingJackson2XmlHttpMessageConverter.class,converter.getClass())));
        this.restTemplate.getMessageConverters().add(new XmlMessageConverter<>());
        //需要替换ObjectMapper, 否则日期处理会有问题
        ObjectMapper objectMapper = new ObjectMapper();
        // 忽略对象中不存在的字段
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule
                .addSerializer(LocalDate.class, new JacksonConfiguration.LcpLocalDateSerializer())
                .addDeserializer(LocalDate.class, new JacksonConfiguration.LcpLocalDateDeserializer())
                .addSerializer(ZonedDateTime.class, new JacksonConfiguration.LcpZonedDateTimeSerializer())
                .addDeserializer(ZonedDateTime.class, new JacksonConfiguration.LcpZonedDateTimeDeserializer());
        objectMapper.registerModule(javaTimeModule);
        this.restTemplate.getMessageConverters().stream().filter(e -> e instanceof MappingJackson2HttpMessageConverter)
                .map(e -> (MappingJackson2HttpMessageConverter) e).forEach(e -> e.setObjectMapper(objectMapper));
    }

    @Override
    public <T, R> RemoteCallResponse<R> call(RemoteCallRequest<T, R> request) {
        if (!(request instanceof HttpCallRequest)) {
            throw new RuntimeException(request.getClass().toString() + " cant cast to HttpCallRequest");
        }
        //构建httpEntity
        HttpCallRequest<T, R> httpCallRequest = (HttpCallRequest<T, R>) request;
        try {
            ResponseEntity<R> responseEntity;
            boolean firstQueryString = true;
            if (!CollectionUtils.isEmpty(httpCallRequest.getQueryString())) {
                for (String queryString : httpCallRequest.getQueryString()) {
                    if (firstQueryString) {
                        httpCallRequest.setUrl(httpCallRequest.getUrl() + "?" + queryString);
                        firstQueryString = false;
                        continue;
                    }
                    httpCallRequest.setUrl(httpCallRequest.getUrl() + "&" + queryString);
                }
            }
            if (null == httpCallRequest.getReturnClazz()) {
                responseEntity = restTemplate.exchange(
                        httpCallRequest.getUrl(),
                        httpCallRequest.getRequestMethod(),
                        httpCallRequest.buildHttpEntity(),
                        httpCallRequest.getCollectionReturnClazz()
                );
            } else {
                responseEntity = restTemplate.exchange(
                        httpCallRequest.getUrl(),
                        httpCallRequest.getRequestMethod(),
                        httpCallRequest.buildHttpEntity(),
                        httpCallRequest.getReturnClazz()
                );
            }
            return new HttpCallResponse<>(responseEntity.getBody());
        } catch (RestClientResponseException e) {
            throw new HttpCodeException(e.getRawStatusCode(),e.getResponseBodyAsString());
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    @Override
    public String protocolType() {
        return "HTTP";
    }
}
