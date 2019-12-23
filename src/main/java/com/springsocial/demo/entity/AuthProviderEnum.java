package com.springsocial.demo.entity;

public enum AuthProviderEnum {
    LOCAL("local"),
    FACEBOOK("facebook"),
    GOOGLE("google"),
    GITHUB("github");

    private String name;

    AuthProviderEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
