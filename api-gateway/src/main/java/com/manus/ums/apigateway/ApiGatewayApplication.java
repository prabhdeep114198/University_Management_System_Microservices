package com.manus.ums.apigateway;

import com.manus.ums.apigateway.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    @Autowired
    private AuthenticationFilter authFilter;

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        AuthenticationFilter.Config config = new AuthenticationFilter.Config();

        return builder.routes()
                // AUTH routes (no authentication required)
                .route("auth-service", r -> r.path("/auth/**")
                        .uri("lb://AUTH-SERVICE"))

                // STUDENT routes (apply JWT filter)
                .route("student-service", r -> r.path("/students/**")
                        .filters(f -> f.filter(authFilter.apply(config)))
                        .uri("lb://STUDENT-SERVICE"))

                // FACULTY routes
                .route("faculty-service", r -> r.path("/faculty/**")
                        .filters(f -> f.filter(authFilter.apply(config)))
                        .uri("lb://FACULTY-SERVICE"))

                // DEPARTMENT routes
                .route("department-service", r -> r.path("/departments/**")
                        .filters(f -> f.filter(authFilter.apply(config)))
                        .uri("lb://DEPARTMENT-SERVICE"))

                // COURSE routes
                .route("course-service", r -> r.path("/courses/**")
                        .filters(f -> f.filter(authFilter.apply(config)))
                        .uri("lb://COURSE-SERVICE"))

                // ENROLLMENT routes
                .route("enrollment-service", r -> r.path("/enrollments/**")
                        .filters(f -> f.filter(authFilter.apply(config)))
                        .uri("lb://ENROLLMENT-SERVICE"))

                .build();
    }
}
