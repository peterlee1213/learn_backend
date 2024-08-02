package com.example.s02_user_authentication_based_on_database.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfig {

    /**
     * 根据源码，通过搜索spring容器中UserDetailsService类型的bean,然后找到第一个，然后使用
     * 这就意味着我可定义多个UserDetailsService类型的bean,但是只有第一个有用
     * 也意味着名称我可以随便起
     * 
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        DBUserDetailsManager manager = new DBUserDetailsManager();
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 开启授权保护
        http
                .authorizeHttpRequests(authorize -> authorize
                        // anyRequest表示对所有请求开启授权保护
                        .anyRequest()
                        // 已认证的用户授权全部权限
                        .authenticated())
                // 自动使用表单授权，没有这个选项的话会返回401以及一个www-authentication头部以及Basic的值，这两个结合起来会让浏览器弹出一个输入用户名和密码的弹窗，而非一个UI登陆页面
                // 登陆页面登陆流程，登出页登出流程都是下面这个选项提供的
                .formLogin(withDefaults())
        // 使用基本授权方式
        // .httpBasic(withDefaults())
        ;

        http.csrf(csrf -> {
            csrf.disable();
        });

        return http.build();
    }

}
