package com.powernode.mybatis_plus_01_startup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.powernode.mybatis_plus_01_startup.domain.User;
import com.powernode.mybatis_plus_01_startup.service.UserService;

@RestController
@RequestMapping("/01")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("selectAll")
    public List<User> selectAll() {
        List<User> users = userService.selectAll();
        return users;
    }
}
