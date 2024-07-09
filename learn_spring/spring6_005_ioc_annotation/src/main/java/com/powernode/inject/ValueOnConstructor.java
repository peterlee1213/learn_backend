package com.powernode.inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
// @Value可用在构造方法上
public class ValueOnConstructor {
    private String name;
    private int age;

    public ValueOnConstructor(@Value("constructor") String name, @Value("55") int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ValueOnConstructor [name=" + name + ", age=" + age + "]";
    }

}
