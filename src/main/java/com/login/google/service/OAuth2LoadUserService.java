package com.login.google.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OAuth2LoadUserService extends DefaultOAuth2UserService implements IOAuth2LoadUserService{

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        //guardar o no los datos del usuario oAuth2User

        //crear el JWT (jwtUtils.createToken())

        return oAuth2User;
    }

    @Override
    public Map<String, Object> returnJWT(OAuth2AuthorizedClient authorizedClient) {
        OAuth2UserRequest oauth2UserRequest = new OAuth2UserRequest(
                clientRegistrationRepository
                        .findByRegistrationId(authorizedClient.getClientRegistration()
                                .getRegistrationId()),
                authorizedClient.getAccessToken());

        return this.loadUser(oauth2UserRequest).getAttributes();
    }


}
