package com.powernode.Five;

public class User {

    private String name;

    public User() {
        System.out.println("1. invoke constructor");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2. invoke setter");
    }

    public void initBean() {
        System.out.println("3. init Bean, 方法名随意, 方法要自己写自己配");
    }

    public void destroyBean() {
        System.out.println("5. destroy Bean, 方法名随意, 方法要自己写");
    }
}
