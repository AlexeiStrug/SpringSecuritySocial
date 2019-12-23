package com.springsocial.demo.controller.dto;

public class AuthResponseDto {
    private String accessToken;
    private String tokenType = "Bearer";

    public AuthResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public AuthResponseDto setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getTokenType() {
        return tokenType;
    }

    public AuthResponseDto setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }
}
