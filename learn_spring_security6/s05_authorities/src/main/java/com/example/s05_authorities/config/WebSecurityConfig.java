package com.example.s05_authorities.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity // 开启基于方法的授权
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /**
         * 需要注意的是：
         * 权限的匹配是子上而下的，比如我定义了两条权限分配规则
         * .requestMatchers("/admin/list").hasAuthority("ADMIN_LIST")
         * .requestMatchers("/admin/**").hasRole("ADMIN")
         * 这会导致如果一个用户有ADMIN角色但是没有分配ADMIN_LIST权限，他会被禁止访问/admin/list
         */
        http.authorizeHttpRequests(authorize -> {
            authorize
                    // .requestMatchers("/admin/list").hasAuthority("ADMIN_LIST") //
                    // 所有具有ADMIN_LIST权限的才能访问/admin/list
                    // .requestMatchers("/admin/**").hasRole("ADMIN") // 将资源跟角色做映射关系
                    // 剩下的所有请求只要经过认证（登陆）就都可以访问
                    .anyRequest().authenticated();
        });

        // 开启内置表单验证
        http.formLogin(withDefaults());

        // 出现401/403/5xx等各种exception的时候如何处理
        http.exceptionHandling(exception -> {
            // 出现403未授权的时候使用MyAccessDeniedHandler返回一个自定义格式的JSON字符串
            exception.accessDeniedHandler(new MyAccessDeniedHandler());
        });

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
