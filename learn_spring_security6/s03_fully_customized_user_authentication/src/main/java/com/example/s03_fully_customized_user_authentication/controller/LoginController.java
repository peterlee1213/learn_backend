package com.example.s03_fully_customized_user_authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 自定义登陆页面controller
 */
@Controller
public class LoginController {

    /**
     * 仅定义一个login路由返回页面还不行，因为spring security自动配置了一系列的filter,用于拦截url,所以默认返回的还是spring
     * security自带的登陆页面, 需要做如下配置：
     * 1. WebSecurityConfig中配置停止使用默认登陆页并配置自己的登陆页URL
     * 2. 关闭对登陆页面开启授权保护
     * 
     * @param param
     * @return
     */
    @GetMapping("/login")
    public String getMethodName(@RequestParam String param) {
        return "login";

    }
}
