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

        return (RequestTemplate template) -> {
            ServletRequestAttributes attributes =
                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

            if (attributes == null) {
                return; // No HTTP request context
            }

            var request = attributes.getRequest();

            String userId = request.getHeader("X-User-Id");
            String userRoles = request.getHeader("X-User-Roles");
            String authHeader = request.getHeader("Authorization"); // optional

            if (userId != null) {
                template.header("X-User-Id", userId);
            }

            if (userRoles != null) {
                template.header("X-User-Roles", userRoles);
            }

            // Optional: forward Authorization if needed
            if (authHeader != null) {
                template.header("Authorization", authHeader);
            }
        };
    }
}
