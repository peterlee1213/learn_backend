package com.example.security_06_config_role_privileges.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CurrentLoginUserController {

    @GetMapping("/getUserInfo")
    public Authentication getUserInfAuthentication(@Autowired Authentication authentication) {
        return authentication;
    }

}
