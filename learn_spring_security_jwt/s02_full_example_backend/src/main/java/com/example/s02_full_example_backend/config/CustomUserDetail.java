package com.example.s02_full_example_backend.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomUserDetail extends User {

    private String phoneNumber;

    public CustomUserDetail(Long id, String userName, String password, Boolean enabled, String phoneNumber,
            Collection<? extends GrantedAuthority> authorities) {
        super(userName, password, enabled, true, true, true, authorities);
        this.phoneNumber = phoneNumber;
    }

}
