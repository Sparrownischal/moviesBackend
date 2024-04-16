package com.example.movieapp_backend.controllers;

import java.security.SecureRandom;
import java.util.Base64;

public class JwtSecretGenerator {

    public static void main(String[] args) {
        // Generate a secure random byte array
        SecureRandom secureRandom = new SecureRandom();
        byte[] secretBytes = new byte[64];
        secureRandom.nextBytes(secretBytes);

        // Convert the byte array to a base64-encoded string
        String jwtSecret = Base64.getEncoder().encodeToString(secretBytes);

        // Output the generated JWT secret key
        System.out.println("Generated JWT Secret Key: " + jwtSecret);
    }
}
