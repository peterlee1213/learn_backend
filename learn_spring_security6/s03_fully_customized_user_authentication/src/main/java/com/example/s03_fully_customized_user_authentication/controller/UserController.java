package com.example.s03_fully_customized_user_authentication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.s03_fully_customized_user_authentication.domain.SysUser;
import com.example.s03_fully_customized_user_authentication.repository.UserRepository;

import jakarta.annotation.Resource;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/3")
public class UserController {
    @Resource
    private UserRepository userRepository;

    @Resource
    private UserDetailsManager userDetailsManager;

    @GetMapping("/getList")
    public List<SysUser> getList() {
        return userRepository.findAll();
    }

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody SysUser user) {
        user.setId(null);
        userDetailsManager.createUser(User.builder().username(user.getUsername()).password(user.getPassword())
                .disabled(!user.getEnabled()).build());
    }

}
