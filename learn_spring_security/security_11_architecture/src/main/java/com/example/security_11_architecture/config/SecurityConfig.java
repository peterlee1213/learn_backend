package com.example.security_11_architecture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.DisableEncodeUrlFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /** 这是针对DefaultSecurityFilterChain的配置 */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
           http.authorizeHttpRequests(authorize -> {
            authorize
                    .requestMatchers("/hello").anonymous()
                    .anyRequest().authenticated();
        });

        http.addFilterBefore(new HeaderFilter(), DisableEncodeUrlFilter.class);

        // 开启内置表单验证
        http.formLogin(withDefaults());

        // 出现401/403/5xx等各种exception的时候如何处理
        http.exceptionHandling(exception -> {
            // 出现403未授权的时候使用MyAccessDeniedHandler返回一个自定义格式的JSON字符串
            exception.accessDeniedHandler(new MyAccessDeniedHandler());
        });


        return http.build();
    }

}