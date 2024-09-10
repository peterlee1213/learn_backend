package com.example.security_11_architecture.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getMethodName() {
        return "此接口不需要登陆访问，但因为添加了一个自定义Filter, 必须得在请求中添加特定的header才能验证通过";
    }
    
}
