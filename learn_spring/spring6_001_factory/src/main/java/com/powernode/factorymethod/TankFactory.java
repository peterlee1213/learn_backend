package com.powernode.factorymethod;

/**
 * 具体工厂角色
 */
public class TankFactory extends WeaponFactory {

    @Override
    public Weapon get() {
        return new Tank();
    }

}
