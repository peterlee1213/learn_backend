package com.example.s01_fundment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    // private JwtAuthenticationFilter

    /**
     * AuthenticationManager接口有一个authenticate方法，这个方法负责对用户登陆进行认证操作
     * 这里我们通过重写AuthenticationManager这个bean可重写认证流程
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * 配置SecurityFilterChain
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 开启跨域访问
        http.csrf(csrf -> csrf.disable());

        // 配置对特定URL的访问权限
        http.authorizeHttpRequests(authorize -> {
            authorize.requestMatchers("/user/login").permitAll() // /user/login直接允许无需认证
                    .anyRequest().authenticated(); // 其他所有url都需要认证
        });
        // 把token校验过滤器添加到过滤器链中
        // http.addFilterBefore(null, null)

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
