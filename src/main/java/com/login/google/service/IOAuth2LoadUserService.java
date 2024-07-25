package com.login.google.service;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;

import java.util.Map;

public interface IOAuth2LoadUserService {

    Map<String, Object> returnJWT(OAuth2AuthorizedClient authorizedClient);
}
