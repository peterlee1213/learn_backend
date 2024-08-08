package com.example.s01_fundment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.s01_fundment.common.R;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public R login(@RequestBody UserLoginObj userLoginObj) {

    }

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class UserLoginObj {
    private String username;
    private String password;
}
