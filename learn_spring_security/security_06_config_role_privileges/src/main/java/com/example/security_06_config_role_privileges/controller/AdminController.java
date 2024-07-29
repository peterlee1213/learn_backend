package com.example.security_06_config_role_privileges.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/admin")
@RestController
public class AdminController {
    @GetMapping("query")
    public String query() {
        return new String("admin query");
    }

}
