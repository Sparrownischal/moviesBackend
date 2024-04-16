package com.example.movieapp_backend.controllers;

import com.example.movieapp_backend.models.UserModel;
import com.example.movieapp_backend.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Optional;

@RestController
public class AuthenticationController {

    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserLoginDTO userLoginDTO) {
        boolean isAuthenticated = userService.authenticateUser(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        if (isAuthenticated) {
            // Fetch user details by email
            Optional<UserModel> userOptional = userService.findByEmail(userLoginDTO.getEmail());

            // Check if user exists
            if (userOptional.isPresent()) {
                UserModel user = userOptional.get();

                // Generate JWT token
                String token = generateJwtToken(user.getEmail());

                // Return token and user details in response
                AuthenticationResponse response = new AuthenticationResponse(token, user.getFullName(), user.getEmail());
                return ResponseEntity.ok().body(response);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User not found");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }

    private String generateJwtToken(String email) {
        String jwtSecret = "v+vnU0inFU6K+jfGeVQYYUacciAE7r06o0g4rAa1DL/bSWtINDSKkq3xs6W0oPmf42kVwy3Yava/FPcn1RVAgg==";
        long jwtExpiration = 86400000; // 1 day in milliseconds

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}
