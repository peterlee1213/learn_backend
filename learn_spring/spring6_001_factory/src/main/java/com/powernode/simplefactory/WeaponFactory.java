package com.powernode.simplefactory;

/**
 * 工厂类角色
 */
public class WeaponFactory {
    public static Weapon get(String WeaponType) {
        switch (WeaponType) {
            case "Tank":
                return new Tank();
            case "Fighter":
                return new Fighter();
            default:
                return null;
        }
    }
}
