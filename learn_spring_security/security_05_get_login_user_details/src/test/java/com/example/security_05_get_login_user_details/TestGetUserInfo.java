package com.example.security_05_get_login_user_details;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootTest
public class TestGetUserInfo {

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Test
    public void testGetUserInfo() {
        UserDetails userLisi = userDetailsService.loadUserByUsername("lisi");
        System.out.println(userLisi.getUsername());
        System.out.println(userLisi.getPassword());
        System.out.println(userLisi.isEnabled());
        System.out.println(userLisi.isCredentialsNonExpired());
    }

}
