package com.example.security_13_customize_login_controller.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class LoginController {

    @Resource
    private AuthenticationManager authenticationManager;

    // 注意：必须要关闭formLogin才能让/login的post请求走自定义的Controller
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        // 将用户名和密码封装为一个简单的Authentication对象
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken
                .unauthenticated(loginRequest.username(), loginRequest.password());
        // 认证成功之后返回一个各种信息填充完整的Authentication对象
        Authentication authenticationResponse = authenticationManager.authenticate(authenticationRequest);
        /**
         * 将认证成功之后返回的Authentication对象添加到SecurityContextHolder中，只要特定Authentication对象在SecurityContextHolder
         * 中存在就证明这个用户已经通过认证了
         * 但是怎么获取JSESSIONID还不知道
         */
        SecurityContextHolder securityContextHolder = new SecurityContextHolder();
        SecurityContext emptyContext = securityContextHolder.createEmptyContext();
        emptyContext.setAuthentication(authenticationResponse);
        securityContextHolder.setContext(emptyContext);

        return new ResponseEntity<Object>(emptyContext.getAuthentication(), HttpStatusCode.valueOf(200));
    }

}

record LoginRequest(String username, String password) {
}
