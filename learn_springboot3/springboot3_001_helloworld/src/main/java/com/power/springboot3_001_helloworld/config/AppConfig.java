package com.power.springboot3_001_helloworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.power.springboot3_001_helloworld.bean.User;

@Configuration
public class AppConfig {

    @Bean("user01")
    public User user() {
        return new User(1L, "张三");
    }
}
