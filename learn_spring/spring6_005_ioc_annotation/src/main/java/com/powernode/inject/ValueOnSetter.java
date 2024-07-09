package com.powernode.inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
// Value可用在Setter方法上
public class ValueOnSetter {
    private String name;
    private int age;

    @Value("李斯")
    public void setName(String name) {
        this.name = name;
    }

    @Value("33")
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ValueOnSetter [name=" + name + ", age=" + age + "]";
    }

}
