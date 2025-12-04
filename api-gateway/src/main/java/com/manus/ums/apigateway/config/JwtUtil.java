package com.manus.ums.apigateway.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public void validateToken(String token) throws Exception {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        } catch (SignatureException e) {
            throw new Exception("Invalid JWT signature");
        } catch (Exception e) {
            throw new Exception("JWT validation failed");
        }
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
}
