package com.example.security_06_config_role_privileges.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MySecurityUserConfig {

    @Bean("userDetailsService")
    public UserDetailsService userDetailsService() {
        /**
         * roles和authorities都可设置权限，以student为例
         * 1. 如果authorities在后面，最后的权限就是student:delete和student:add
         * 2. 如果roles在后面，最后的权限就是ROLE_student
         */
        UserDetails user1 = User.builder().username("zhangsan").password(passwordEncoder().encode("123456"))
                .authorities("student:delete", "student:add").roles("student").build();
        UserDetails user2 = User.builder().username("lisi").password(passwordEncoder().encode("123456"))
                .authorities("teacher:delete", "teacher:add").roles("teacher").build();
        InMemoryUserDetailsManager im = new InMemoryUserDetailsManager();
        im.createUser(user1);
        im.createUser(user2);
        return im;
    }

    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
