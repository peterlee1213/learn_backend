package com.powernode.simplefactory;

/**
 * 工厂类角色
 */
public class WeaponFactory {
    public static Weapon get(String weaponType) {
        if (weaponType.equals("tank")) {
            return new Tank();
        }

        return null;
    }
}
