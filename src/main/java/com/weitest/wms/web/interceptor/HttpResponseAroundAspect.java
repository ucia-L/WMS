package com.weitest.wms.web.interceptor;

import com.weitest.wms.domain.http.HttpResponse;
import com.weitest.wms.util.GlobalContext;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;
/**
 * httpResponse injection handle
 */
@Component
@Aspect
public class HttpResponseAroundAspect {

    @After(value = "@annotation(com.weitest.wms.web.interceptor.annotation.HttpResponseAround)")
    public void pointcut() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        if(Objects.nonNull(response)){
            List<HttpResponse> list = GlobalContext.findHttpResponseFieldsInSessionVariables();
                if(!CollectionUtils.isEmpty(list)){
                for (int l = 0; l < list.size(); l++) {
                HttpResponse httpResponse =list.get(l);
                httpResponse.copyProperties(httpResponse,response);
                }
            }
        }
    }

}
