package com.example.demo.JWT;

public interface JwtProperties {
    String SECRET = "SomeSecretForJWTGenerationSomeSecretForJWTGenerationSomeSecretForJWTGeneration";
    int EXPIRATION_TIME = 864_000_000; // 10 days
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
