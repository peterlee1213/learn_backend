package com.example.s01_fundment.service.impl;

import java.util.Objects;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson2.JSON;
import com.example.s01_fundment.entities.SysUser;
import com.example.s01_fundment.entities.vo.LoginUser;
import com.example.s01_fundment.service.UserService;
import com.example.s01_fundment.utils.JwtUtil;

import jakarta.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public String login(SysUser sysUser) {

        // 1. 封装Authentication对象
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                sysUser.getUserName(), sysUser.getPassword());
        // 2. 进行校验
        Authentication authenticate = authenticationManager.authenticate(authentication);
        // 3. 如果authenticate为空，则校验失败
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登陆失败");
        }
        // 放入用户信息
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        // 生成jwt,使用fastjson的方法，把对象转换为字符串
        String loginUserString = JSON.toJSONString(loginUser);
        // 调用JWT工具类，生成jwt令牌
        String jwt = JwtUtil.createJWT(loginUserString, null);
        return jwt;
    }

}
