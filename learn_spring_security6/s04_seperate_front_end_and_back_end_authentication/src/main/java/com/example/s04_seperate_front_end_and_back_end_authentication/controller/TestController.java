package com.example.s04_seperate_front_end_and_back_end_authentication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/4")
public class TestController {

    @GetMapping("/hello")
    public String getMethodName() {
        return new String("hello world");
    }

}
