package com.powernode.factoryBean;

/**
 * 具体产品角色
 */
public class TankFactory extends WeaponFactory {

    @Override
    public Weapon get() {
        return new Tank();
    }

}
