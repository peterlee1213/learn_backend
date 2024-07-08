package com.powernode.factorymethod;

/**
 * 客户端程序
 */
public class Test {
    public static void main(String[] args) {
        TankFactory tf = new TankFactory();
        Weapon weapon = tf.get();
        weapon.attack();
    }
}
