package com.example.s04_seperate_front_end_and_back_end_authentication.config;

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
                .anyRequest()
                .authenticated());
        // 登陆配置
        http.formLogin(form -> {
            form
                    .usernameParameter("myusername") // 自定义用户名参数名称，默认是username
                    .passwordParameter("mypassword") // 自定义密码参数名称，默认是password
                    .failureUrl("/login?failure") // 验证失败跳转的地址，默认是/login?error
                    .successHandler(new MyAuthenticationSuccessHandler()) // 默认登陆成功之后去首页，通过此方法定义验证成功之后的行为
                    .failureHandler(new MyAuthenticationFailureHandler()); // 默认登陆失败去/login?error,通过此方法定义验证成功之后的行为
        });
        // 登出配置
        http.logout(logout -> {
            logout.logoutSuccessHandler(new MyLogoutSuccessHandler()); // 注销成功时的处理
        });

        // 各种异常以及其配置
        http.exceptionHandling(exception -> {
            // 请求未认证的处理,如果把此选项打开就无法访问登陆页面了
            // exception.authenticationEntryPoint(new MyAuthenticationEntryPoint());
        });

        // 会话配置
        http.sessionManagement(session -> {
            session
                    .maximumSessions(1) // 针对同一个帐号可有几个会话同时登陆，后登陆的帐号会将先登陆的帐号挤掉
                    .expiredSessionStrategy(new MySessionInformationExpiredStrategy()); // 先登陆的帐号被挤掉之后下一次请求返回给客户端的json响应
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
