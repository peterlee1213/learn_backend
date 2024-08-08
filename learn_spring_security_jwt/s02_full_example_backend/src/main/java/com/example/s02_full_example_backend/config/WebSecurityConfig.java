package com.example.s02_full_example_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.s02_full_example_backend.config.handler.LoginSuccessHandler;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 配置授权
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login").anonymous()
                .requestMatchers("/logout").anonymous()
                .anyRequest().authenticated());

        // 登陆配置
        http.formLogin(form -> {
            form
                    .successHandler(new LoginSuccessHandler());
        });

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
