package com.springsocial.demo.controller;

import com.springsocial.demo.config.security.entity.CurrentUser;
import com.springsocial.demo.config.security.entity.UserPrincipal;
import com.springsocial.demo.config.security.utils.exception.ResourceNotFoundException;
import com.springsocial.demo.entity.UserEntity;
import com.springsocial.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserEntity getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
