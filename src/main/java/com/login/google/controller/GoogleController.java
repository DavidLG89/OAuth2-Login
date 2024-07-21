package com.login.google.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login/oauth2/code")
@Slf4j
public class GoogleController {


    @GetMapping("/google")
    public ResponseEntity<String> handleGoogleCallback(@RequestParam String code) {
        log.info("code: {}", code);
        return new ResponseEntity<>(code, HttpStatus.OK);
    }
}
