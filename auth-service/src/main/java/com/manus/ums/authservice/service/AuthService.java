package com.manus.ums.authservice.service;

import com.manus.ums.authservice.dto.AuthRequest;
import com.manus.ums.authservice.dto.AuthResponse;
import com.manus.ums.authservice.dto.RegisterRequest;
import com.manus.ums.authservice.entity.User;
import com.manus.ums.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public User register(RegisterRequest request) {
        if (repository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        return repository.save(user);
    }

    public AuthResponse login(AuthRequest request) {
        Optional<User> userOptional = repository.findByUsername(request.getUsername());

        if (userOptional.isEmpty() || !passwordEncoder.matches(request.getPassword(), userOptional.get().getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        User user = userOptional.get();
        String accessToken = jwtService.generateToken(user.getUsername(), user.getRole());
        String refreshToken = jwtService.generateRefreshToken(user.getUsername(), user.getRole());

        return new AuthResponse(accessToken, refreshToken);
    }

    public AuthResponse refreshToken(String refreshToken) {
        if (jwtService.isTokenExpired(refreshToken)) {
            throw new RuntimeException("Refresh token expired");
        }
        String username = jwtService.extractUsername(refreshToken);
        User user = repository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

        String newAccessToken = jwtService.generateToken(user.getUsername(), user.getRole());
        String newRefreshToken = jwtService.generateRefreshToken(user.getUsername(), user.getRole());

        return new AuthResponse(newAccessToken, newRefreshToken);
    }

    public void validateToken(String token) {
        // Validation is handled by JwtService, which throws an exception on failure
        jwtService.extractUsername(token);
    }
}

