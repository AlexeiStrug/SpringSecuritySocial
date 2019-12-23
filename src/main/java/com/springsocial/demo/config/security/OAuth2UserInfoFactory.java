package com.springsocial.demo.config.security;

import com.springsocial.demo.config.security.impl.FacebookOAuth2UserInfo;
import com.springsocial.demo.config.security.impl.GithubOAuth2UserInfo;
import com.springsocial.demo.config.security.impl.GoogleOAuth2UserInfo;
import com.springsocial.demo.entity.AuthProviderEnum;
import com.springsocial.demo.config.security.utils.exception.OAuth2AuthenticationProcessingException;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        Optional<AuthProviderEnum> registrationIdEnumValue = Arrays.stream(AuthProviderEnum.values())
                .filter(value -> value.name().equals(registrationId))
                .findFirst();
        return switch (Objects.requireNonNull(registrationIdEnumValue.orElse(null))) {
            case FACEBOOK -> new FacebookOAuth2UserInfo(attributes);
            case GOOGLE -> new GoogleOAuth2UserInfo(attributes);
            case GITHUB -> new GithubOAuth2UserInfo(attributes);
            default -> throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        };
    }
}
