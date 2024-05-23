package com.weitest.wms.config;

import com.weitest.wms.iam.auth.AuthManager;
import com.weitest.wms.web.interceptor.UserContextFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class UserContextConfiguration {
    @Bean
    public FilterRegistrationBean userContextFilterReg(AuthManager authManager) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new UserContextFilter(authManager));
        registration.addUrlPatterns("/*");
        registration.setName(UserContextFilter.class.getSimpleName());
        registration.setOrder(0);
        return registration;
    }
}