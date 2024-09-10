package com.example.security_03_create_multiuser_in_memory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 自定义类实现UserDetailsService接口，loadUserByUsername根据用户名找到用户细节信息
 * 比如用户名和密码，或者用户权限，用户是否被锁定等等，具体看这个方法返回的UserDetails
 * 对象
 */

@Configuration // @Configuration表示当前class作为一个spring bean,以及内部有@Bean标注的函数的返回值也成为bean
public class MySecurityUserConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // UserDetails对象包括一个用户的全部信息，比如用户名和密码，或者用户权限，用户是否被锁定等等
        UserDetails user1 = User.builder().username("zhangsan").password("123456").roles("student").build();
        UserDetails user2 = User.builder().username("lisi").password("123456").roles("teacher").build();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(user1);
        manager.createUser(user2);
        return manager;
    }

    /**
     * 自定义一个密码编码器，spring security要求必须定义密码编码器
     * 当前NoOpPasswordEncoder表示直接使用明文密码
     * 密码编码器接口中提供了方法用于对密码进行加密以及验证
     * 
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
