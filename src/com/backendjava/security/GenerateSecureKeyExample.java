package com.backendjava.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class GenerateSecureKeyExample {
    public static void main(String[] args) {
        // Generate a secure key for HS512 algorithm
        System.out.println("signatureAlgorithm = "+SignatureAlgorithm.HS512);
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        // Use the generated key for signing JWTs
        System.out.println("Generated Secure Key: " + key);
    }
}
