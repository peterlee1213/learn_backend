package com.powernode.springboot3_003_core_annotation.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    @Autowired
    @Qualifier("myDate")
    private Date date;

    @GetMapping("/hello")
    public String hello() {
        return new String("hello world from springboot 3" + this.date);
    }

}
