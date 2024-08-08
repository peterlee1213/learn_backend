package com.example.s01_fundment.config;

import java.beans.JavaBean;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import com.example.s01_fundment.entities.SysUser;
import com.example.s01_fundment.repositories.SysUserRepository;

import jakarta.annotation.Resource;

@Component
public class DbUserManager implements UserDetailsManager, UserDetailsPasswordService, UserDetails {

    @Resource
    private SysUserRepository sysUserRepository;

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createUser(UserDetails user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteUser(String username) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateUser(UserDetails user) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean userExists(String username) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SysUser> sysUser = sysUserRepository.findByUserName(username);
        try {
            SysUser sysUser2 = sysUser.get();
            return User.builder().username(sysUser2.getUserName()).password(sysUser2.getPassword())
                    .disabled(sysUser2.getStatus() == '1').build();
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException(username + " not found", e);
        }
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return UserDetails.super.isEnabled();
    }

}
