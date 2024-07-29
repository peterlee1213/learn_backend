package com.example.security_04_encrypt_password.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("query")
    public String query() {
        return "student query";
    }

}
