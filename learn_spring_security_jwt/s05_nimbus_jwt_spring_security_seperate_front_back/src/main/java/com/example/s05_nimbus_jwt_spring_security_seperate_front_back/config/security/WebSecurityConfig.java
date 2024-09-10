package com.example.s05_nimbus_jwt_spring_security_seperate_front_back.config.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 授权配置
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login", "/logout").permitAll()
                .anyRequest()
                .authenticated());

        // 各种异常以及其配置
        http.exceptionHandling(exception ->

        {
            // 请求未认证的处理,如果把此选项打开就无法访问登陆页面了
            // exception.authenticationEntryPoint(new MyAuthenticationEntryPoint());
        });

        // 跨域配置
        /**
         * 在前后端分离的架构中，前端和后端一般来说协议+域名+端口号是不一样的
         * 所以需要后端服务器开启对前端服务器的跨域访问权限
         * 以下配置可开启对所有来源的跨域访问
         */
        http.cors(withDefaults());

        // scrf攻击相关配置
        http.csrf(csrf -> {
            csrf.disable();
        });

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
