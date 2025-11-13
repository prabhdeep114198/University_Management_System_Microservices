package com.manus.ums.studentservice.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                if (attributes != null) {
                    String userId = attributes.getRequest().getHeader("X-User-Id");
                    String userRoles = attributes.getRequest().getHeader("X-User-Roles");
                    
                    if (userId != null) {
                        template.header("X-User-Id", userId);
                    }
                    if (userRoles != null) {
                        template.header("X-User-Roles", userRoles);
                    }
                    // Alternatively, forward the Authorization header if needed, but X-User-Roles is safer for internal communication
                }
            }
        };
    }
}

