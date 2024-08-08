package com.example.s02_full_example_backend.config.handler;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.alibaba.fastjson2.JSON;
import com.example.s02_full_example_backend.common.R;
import com.example.s02_full_example_backend.utils.JwtUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        R r = R.ok();
        r.data("token", JwtUtil.createJWT(authentication, "hello", null));
        String json = JSON.toJSONString();
    }

}
