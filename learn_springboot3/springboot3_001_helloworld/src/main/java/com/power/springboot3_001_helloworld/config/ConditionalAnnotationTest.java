package com.power.springboot3_001_helloworld.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.power.springboot3_001_helloworld.bean.User;

@Configuration
public class ConditionalAnnotationTest {

    /**
     * 只要user01这个bean存在就执行下面的方法
     */
    @ConditionalOnBean(name = { "user01" })
    @Bean
    public User user01Exist() {
        System.out.println("user01存在");
        return new User();
    }

    /**
     * 只要这个class存在就执行某些操作
     */
    @ConditionalOnClass(com.power.springboot3_001_helloworld.bean.User.class)
    @Bean
    public User userClassExist() {
        System.out.println("User class存在");
        return new User();
    }

}
