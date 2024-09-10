package com.powernode.springboot3_004_configuration_file.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 这个配置表示读取application.properties中所有mywebapp.xxxx的值并赋值给此类中对应的属性
@ConfigurationProperties(prefix = "mywebapp")
@Component("configBean")
public class BindConfigBean {
    private String name;
    private Integer age;

    public BindConfigBean(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public BindConfigBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BindConfigBean [name=" + name + ", age=" + age + "]";
    }

}
