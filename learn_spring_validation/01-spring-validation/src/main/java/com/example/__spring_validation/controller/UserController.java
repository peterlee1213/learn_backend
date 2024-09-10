package com.example.__spring_validation.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.__spring_validation.entities.NewUserRequestDTO;

import jakarta.validation.Valid;

@RestController
public class UserController {

    @PostMapping("/adduser")
    public NewUserRequestDTO addUser(@Validated @RequestBody NewUserRequestDTO newUserRequestDTO) {
        return newUserRequestDTO;
    }

}
