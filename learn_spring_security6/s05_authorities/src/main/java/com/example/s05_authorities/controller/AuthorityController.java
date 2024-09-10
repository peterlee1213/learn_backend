package com.example.s05_authorities.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AuthorityController {
    @GetMapping("/admin/list")
    // 下面这个注解表示不光访问用户得有ADMIN角色，他的用户名还得是admin
    // @PreAuthorize("hasRole('ADMIN') and authentication.name == 'admin'")
    // 下面注解表示用户得有ADMIN角色才能访问方法
    // 除了hasRole之外还有hasAuthority这个关键字
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminList() {
        return "admin list";
    }

    @GetMapping("/user/list")
    public String getUserLis() {
        return new String("user list");
    }

}
