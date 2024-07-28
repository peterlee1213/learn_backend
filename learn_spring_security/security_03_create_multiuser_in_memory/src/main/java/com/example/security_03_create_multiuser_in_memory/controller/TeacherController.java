package com.example.security_03_create_multiuser_in_memory.controller;

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
