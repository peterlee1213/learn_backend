package com.example.s05_nimbus_jwt_spring_security_seperate_front_back.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.s05_nimbus_jwt_spring_security_seperate_front_back.controllers.loginlogoutdto.LoginProp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LoginLogoutController {

    @PostMapping("/login")
    public Object login(@RequestBody LoginProp loginProp) {
        // TODO: process POST request

        return loginProp;
    }

}
