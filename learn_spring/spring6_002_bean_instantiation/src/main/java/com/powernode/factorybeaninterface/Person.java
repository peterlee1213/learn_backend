package com.powernode.factorybeaninterface;

/**
 * 具体产品角色
 */
public class Person extends Animal {

    @Override
    public void live() {
        System.out.println("person live");
    }

}
