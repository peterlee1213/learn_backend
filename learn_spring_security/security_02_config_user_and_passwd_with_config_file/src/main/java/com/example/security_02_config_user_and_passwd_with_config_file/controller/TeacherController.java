package com.example.security_02_config_user_and_passwd_with_config_file.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @GetMapping("query")
    public String query() {
        return "teacher query";
    }

}
