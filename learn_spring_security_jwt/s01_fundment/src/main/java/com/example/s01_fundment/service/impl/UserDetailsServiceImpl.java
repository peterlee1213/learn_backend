package com.example.s01_fundment.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.s01_fundment.entities.SysUser;
import com.example.s01_fundment.repositories.SysUserRepository;

import jakarta.annotation.Resource;

import com.example.s01_fundment.entities.vo.LoginUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SysUser> userItem = sysUserRepository.findByUserName(username);
        try {
            SysUser sysUser = userItem.get();

            // 临时定义一个权限
            HashSet<GrantedAuthority> set = new HashSet<GrantedAuthority>();
            set.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "student";
                }
            });

            User user = new User(sysUser.getUserName(), sysUser.getPassword(), set);
            // User.builder().username(sysUser.getUserName()).password(sysUser.getPassword())
            // .accountExpired(false)
            // .accountLocked(false).authorities("student").disabled(false).build();
            return new LoginUser(user);
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException(username + " not found", e);
        }
    }

}
