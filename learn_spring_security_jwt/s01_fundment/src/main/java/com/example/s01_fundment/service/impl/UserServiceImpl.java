package com.example.s01_fundment.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.s01_fundment.entities.SysUser;
import com.example.s01_fundment.service.UserService;

import jakarta.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(SysUser sysUser) {

        String userName = sysUser.getUserName();
        try {
            // 1.获取数据库中用户信息向你学习
            UserDetails userByUsername = userDetailsService.loadUserByUsername(userName);
            // 2.对比密码

            // 3.相同则登陆成功并申请jwt并返回
            // 4.失败则返回null
        } catch (UsernameNotFoundException e) {
            return null;
        }

    }

}
