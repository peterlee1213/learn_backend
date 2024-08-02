package com.example.s03_fully_customized_user_authentication.config;

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
    // 注意，我可以直接在DBUserDetailsManager这个类上加@Component注解，这样就解决了DBUserDetailsManager不能进行依赖注入的问题
    // @Bean
    // public UserDetailsService userDetailsService() {
    // DBUserDetailsManager manager = new DBUserDetailsManager();
    // return manager;
    // }

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
                .formLogin(form -> {
                    // permitAll表示无需授权即可访问当前页面，否则一旦访问需要授权的login页面会立刻重新重定向到login页面，会出现重定向次数太多的错误
                    form.loginPage("/login").permitAll();
                });
        // 使用基本授权方式(只有这个选项而没有formLogin的话会使用一个alert弹窗让用户输入帐号密码)
        // .httpBasic(withDefaults());

        http.csrf(csrf -> {
            csrf.disable();
        });

        return http.build();
    }

    // 只要我定义了一个PasswordEncoder类型的bean,这个bean会自动成为密码加密的默认方式
    /**
     * new BCryptPasswordEncoder()接受一个参数范围为[4,31]，默认是10,值越大运算速度越慢，为了放置黑客暴力破解
     * 
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
