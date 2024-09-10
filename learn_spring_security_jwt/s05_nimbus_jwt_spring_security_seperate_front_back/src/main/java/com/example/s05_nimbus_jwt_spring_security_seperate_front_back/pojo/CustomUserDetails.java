package com.example.s05_nimbus_jwt_spring_security_seperate_front_back.pojo;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.s05_nimbus_jwt_spring_security_seperate_front_back.entities.SysUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomUserDetails extends User {
    private SysUser sysUser;

    public CustomUserDetails(SysUser sysUser, UserDetails userDetails) {
        super(userDetails.getUsername(), userDetails.getPassword(), userDetails.isEnabled(),
                userDetails.isCredentialsNonExpired(),
                userDetails.isAccountNonLocked(), userDetails.isAccountNonExpired(), userDetails.getAuthorities());
        this.setSysUser(sysUser);
        this.sysUser.setPassword(null);
    }
}
