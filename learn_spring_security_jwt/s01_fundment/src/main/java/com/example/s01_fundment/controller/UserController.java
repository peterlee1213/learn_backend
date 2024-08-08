package com.example.s01_fundment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.s01_fundment.common.R;
import com.example.s01_fundment.entities.SysUser;
import com.example.s01_fundment.service.UserService;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/info")
    public Authentication getInfo() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        return authentication;
    }

    @PostMapping("/login")
    public R login(@RequestBody SysUser sysUser) {
        String jwt = userService.login(sysUser);
        if (StringUtils.hasLength(jwt)) {
            return R.ok().message("登陆成功").data("token", jwt);
        }
        return R.error().message("登陆失败");
    }

}
