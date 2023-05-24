package com.safenet.fxchangebe.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean<AuthenticationFilter> authFilter() {
        FilterRegistrationBean<AuthenticationFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new AuthenticationFilter());
        registration.addUrlPatterns("/api/*");  // Only match /api/ URLs, can add later
//        registration.addInitParameter("paramName", "paramValue");
        registration.setName("AuthFilter");
        registration.setOrder(1);
        return registration;
    }
}
