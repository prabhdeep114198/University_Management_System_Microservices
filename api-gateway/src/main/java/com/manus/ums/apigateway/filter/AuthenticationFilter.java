package com.manus.ums.apigateway.filter;
import com.manus.ums.apigateway.config.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    public static class Config {
    }

    private static final List<String> openApiEndpoints = List.of(
            "/auth/register",
            "/auth/login",
            "/eureka"
    );

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            // Skip JWT check for open endpoints
            if (openApiEndpoints.stream().noneMatch(uri -> request.getURI().getPath().contains(uri))) {
                List<String> authHeaders = request.getHeaders().get(HttpHeaders.AUTHORIZATION);
                if (authHeaders == null || authHeaders.isEmpty()) {
                    return onError(exchange, "Missing Authorization header", HttpStatus.UNAUTHORIZED);
                }

                String authHeader = authHeaders.get(0);
                if (authHeader.startsWith("Bearer ")) {
                    String token = authHeader.substring(7);
                    try {
                        jwtUtil.validateToken(token);
                        Claims claims = jwtUtil.getAllClaimsFromToken(token);

                        // Forward user info downstream
                        exchange.getRequest().mutate()
                                .header("X-User-Id", claims.getSubject())
                                .header("X-User-Roles", claims.get("roles", String.class))
                                .build();

                    } catch (Exception e) {
                        return onError(exchange, "Invalid or expired JWT Token", HttpStatus.UNAUTHORIZED);
                    }
                } else {
                    return onError(exchange, "Invalid Authorization header format", HttpStatus.UNAUTHORIZED);
                }
            }

            return chain.filter(exchange);
        };
    }

    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus status) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(status);
        return response.setComplete();
    }
}
