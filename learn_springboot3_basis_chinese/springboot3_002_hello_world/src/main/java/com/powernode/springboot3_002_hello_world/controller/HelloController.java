package com.powernode.springboot3_002_hello_world.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class HelloController {

    // 通过浏览器访问/service/hello
    @RequestMapping("/hello")
    public String hello() {
        return "欢迎使用springboot3";
    }
}
