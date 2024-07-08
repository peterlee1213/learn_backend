package com.powernode.simplefactory;

/**
 * 客户端程序
 */
public class Test {
    public static void main(String[] args) {
        Weapon tank = WeaponFactory.get("Tank");
        tank.attack();
    }
}
