package com.power.springboot3_001_helloworld.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 测试属性绑定, 将properties文件中的属性绑定到此类中
 */
// 在实例化此对象的时候, 下面这行代码会将前缀为pig的属性按照对应属性名赋值给此对象的变量
@ConfigurationProperties(prefix = "pig")
@Component("pig")
public class Pig {
    private Long id;
    private String name;
    private Integer age;

    public Pig() {
    }

    public Pig(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Pig [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}
