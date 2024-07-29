package com.example.security_05_get_login_user_details.controller;

import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CurrentLoginUserComtroller {

    /**
     * 获取已登录用户信息, 以下两种方式获取的信息完全相同
     * 
     * @param param
     * @return
     */
    @GetMapping("/getLoginUserInfo1")
    public Authentication getLoginUserInfo1(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/getLoginUserInfo2")
    public Principal getLoginUserInfo2(Principal principal) {
        return principal;
    }

    /**
     * 已登录用户信息保存在安全上下文（ram）中，用户发起请求会携带JSESSIONID的cookie
     * 此方法根据JSESSIONID获取对应登陆用户信息
     */
    @GetMapping("/getLoginUserInfo3")
    public Authentication getLoginUserInfo3() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
}
