package com.powernode.springboot3_004_configuration_file.bean;

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
