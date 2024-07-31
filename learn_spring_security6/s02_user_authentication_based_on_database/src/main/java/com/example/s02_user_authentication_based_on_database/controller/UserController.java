package com.example.s02_user_authentication_based_on_database.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.s02_user_authentication_based_on_database.domain.Tuser;
import com.example.s02_user_authentication_based_on_database.repositories.TuserRepository;

import jakarta.annotation.Resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/2")
public class UserController {

    @Resource
    public TuserRepository tp;

    @GetMapping("/list")
    public List<Tuser> getMethodName() {
        return tp.findAll();
    }

}
