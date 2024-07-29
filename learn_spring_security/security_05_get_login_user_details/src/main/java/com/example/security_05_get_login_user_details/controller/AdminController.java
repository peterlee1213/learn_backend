package com.example.security_05_get_login_user_details.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("query")
    public String query() {
        return "admin query";
    }

}
