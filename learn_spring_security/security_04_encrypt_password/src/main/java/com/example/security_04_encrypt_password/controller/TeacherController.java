package com.example.security_04_encrypt_password.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @GetMapping("query")
    public String query() {
        return "teacher query";
    }

}
