package com.powernode.bean;

public class User {
    private Integer id;
    private String realName;
    private Integer age;

    public User() {
    }

    public User(int id, String realName, int age) {
        this.id = id;
        this.realName = realName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", realName=" + realName + ", age=" + age + "]";
    }

}
