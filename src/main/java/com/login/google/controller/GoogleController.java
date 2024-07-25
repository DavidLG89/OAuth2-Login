package com.login.google.controller;

import com.login.google.service.IOAuth2LoadUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class GoogleController {

    @Autowired
    private IOAuth2LoadUserService ioAuth2LoadUserService;

    @GetMapping("/oauth2/code/google")
    public ResponseEntity<Map<String, Object>> GoogleCallback(@RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient oAuth2AuthorizedClient) {
        return new ResponseEntity<>(ioAuth2LoadUserService.returnJWT(oAuth2AuthorizedClient), HttpStatus.OK);
    }
}
