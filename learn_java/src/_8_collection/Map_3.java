package _8_collection;

import java.util.Map;
import java.util.HashMap;

/**
 * 集合/Map
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265118019954528
 */
public class Map_3 {
    public static void main(String[] args) {
        mapSimpleExample();
        updateMapValue();
        iterateThroughKeys();
        iterateThroughKeyValue();
    }

    // 一般使用方式
    public static void mapSimpleExample() {
        MapExampleClass m = new MapExampleClass("peter", 18);
        Map<String, MapExampleClass> map = new HashMap<>(); // 创建map
        map.put("peter", m); // 向map中添加键值对
        System.out.println(map.get("peter").name); // 根据键获取对应
    }

    // 更新map特定键对应的值: 再次调用put方法, 传入相同键名和不同键值
    public static void updateMapValue() {
        MapExampleClass m = new MapExampleClass("peter", 19);
        MapExampleClass newMapInstance = new MapExampleClass("lee", 99);
        Map<String, MapExampleClass> maps = new HashMap<>();
        maps.put("peter", m);
        System.out.println(maps.get("peter").name); // peter
        maps.put("peter", newMapInstance);
        System.out.println(maps.get("peter").name); // lee
    }

    // 遍历map的key 注意遍历map时不保证顺序
    public static void iterateThroughKeys() {
        Map<String, Integer> m = new HashMap<>();
        m.put("apple", 1);
        m.put("banana", 2);
        m.put("pear", 3);
        for (String key : m.keySet()) {
            System.out.println(m.get(key));
        }
    }

    // 遍历map的key-value 注意遍历map时不保证顺序
    public static void iterateThroughKeyValue() {
        Map<String, Integer> m = new HashMap<>();
        m.put("apple", 1);
        m.put("banana", 2);
        m.put("pear", 3);
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            System.out.printf("%s - %s \n", entry.getKey(), entry.getValue());
        }
    }
}

class MapExampleClass {
    public String name;
    public int score;

    public MapExampleClass(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
