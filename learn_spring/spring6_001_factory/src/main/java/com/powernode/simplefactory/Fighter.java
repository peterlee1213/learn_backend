package com.powernode.simplefactory;

/**
 * 具体产品角色
 */
public class Fighter extends Weapon {

    @Override
    public void attack() {
        System.out.println("Fighter attack");
    }

}
