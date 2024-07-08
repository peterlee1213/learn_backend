package com.powernode.inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
// @Value注解用在属性上可不提供setter方法
public class SimpleValue {

    @Value("zhang")
    private String name;

    @Value("12")
    private int age;

    @Override
    public String toString() {
        return "SimpleValue [name=" + name + ", age=" + age + "]";
    }

}
