package com.example.s03_oauth2_resource_server.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {

    @GetMapping
    public String home(@Autowired Principal principal) {
        return principal.getName();
    }

}
