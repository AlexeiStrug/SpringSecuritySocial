package com.springsocial.demo.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SignUpDto {

    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;

    public String getName() {
        return name;
    }

    public SignUpDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SignUpDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SignUpDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
