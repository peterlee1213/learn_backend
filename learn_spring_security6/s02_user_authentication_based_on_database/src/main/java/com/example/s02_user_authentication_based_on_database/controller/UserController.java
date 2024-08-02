package com.example.s02_user_authentication_based_on_database.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.s02_user_authentication_based_on_database.domain.Tuser;
import com.example.s02_user_authentication_based_on_database.repositories.TuserRepository;
import com.example.s02_user_authentication_based_on_database.config.DBUserDetailsManager;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/2")
public class UserController {

    @Resource
    private TuserRepository tp;

    @Resource
    private PasswordEncoder passwordEncoder;

    private DBUserDetailsManager dbUserDetailsManager = new DBUserDetailsManager();

    @GetMapping("/list")
    public List<Tuser> getUserList() {
        return tp.findAll();
    }

    @PostMapping("/save")
    @Transactional
    public String saveUser(@RequestBody Tuser user) {
        user.setId(null);

        UserDetails userDetails = User.builder().username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword())).build();

        dbUserDetailsManager.createUser(userDetails);
        return "success";
    }

}
