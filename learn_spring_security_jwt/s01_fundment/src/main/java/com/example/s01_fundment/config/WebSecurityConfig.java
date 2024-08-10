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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.s01_fundment.filter.JwtAuthenticationTokenFilter;

import jakarta.annotation.Resource;

@Configuration
public class WebSecurityConfig {

    // 自定义的用于认证的过滤器，进行jwt的校验操作
    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

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
        // 配置过滤器的执行顺序
        // 将我自定义的过滤器放在UsernamePasswordAuthenticationFilter之前，即最开始，我自定义的过滤器优先级最高
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
