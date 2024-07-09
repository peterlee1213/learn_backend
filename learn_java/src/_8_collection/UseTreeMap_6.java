package _8_collection;

import java.util.TreeMap;
import java.util.Comparator;
import java.util.Map;

/**
 * 集合/使用Treemap
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265117109276544
 */
public class UseTreeMap_6 {
    public static void main(String[] args) {
        commonUseCaseOfTreeMap();
        comparableObjectAsKey();
    }

    // TreeMap的一般用法
    public static void commonUseCaseOfTreeMap() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }

    // 作为key的对象需要实现Comparable接口
    public static void comparableObjectAsKey() {
        Map<Person, Integer> map = new TreeMap<>();
        map.put(new Person("amy", 3), 3);
        map.put(new Person("peter", 1), 1);
        map.put(new Person("lee", 2), 2);
        for (Map.Entry<Person, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

// 作为key的对象必须实现Comparable接口
class Person implements Comparable<Person> {
    public String name;
    public int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person p) {
        return this.age - p.age;
    }
}

class PersonWithoutComparable {
    public String name;
    public int age;

    PersonWithoutComparable(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
