package com.backendjava.security;

import io.jsonwebtoken.*;
import java.util.Date;

public class SecurityTokenExample {

    private static final String SECRET_KEY = "SGVsbG8gV29ybGQh"; //your_secret_key_here
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public static String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static void main(String[] args) {
        // Example usage: Generating and validating a token
        String token = generateToken("example_user");
        System.out.println("Generated Token: " + token);

        String username = getUsernameFromToken(token);
        System.out.println("Username from Token: " + username);
    }
}

