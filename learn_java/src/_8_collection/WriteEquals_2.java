package _8_collection;

import java.util.List;
import java.util.Objects;

/**
 * 集合/编写equals方法
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265116446975264#0
 */
public class WriteEquals_2 {
    public static void main(String[] args) {
        equalityTest();
        equalsNotOverrideExample();
        equalsOverrideExample();
    }

    // List中默认使用equals方法判断对象是否相等
    public static void equalityTest() {
        List<String> list = List.of("12", "wetwert", "c");
        System.out.println(list.contains("c")); // true
        System.out.println(list.contains("x")); // false
        System.out.println(list.contains(new String("c"))); // true
        System.out.println(list.indexOf("c")); // 2
    }

    // 自己创建的对象如果不复写equals方法会导致List.contains/indexOf等方法无法执行
    public static void equalsNotOverrideExample() {
        List<NoOverrideEqualsClass> list = List.of(
                new NoOverrideEqualsClass("peter"),
                new NoOverrideEqualsClass("Lee"));
        System.out.println(list.contains(new NoOverrideEqualsClass("peter"))); // false
    }

    // 正确复写equals方法下List.contains/indexOf可正常运行
    public static void equalsOverrideExample() {
        List<OverrideEqualsClass> list = List.of(
                new OverrideEqualsClass("peter", 18),
                new OverrideEqualsClass("lee", 19));
        System.out.println(list.contains(new OverrideEqualsClass("peter", 18))); // true
    }
}

class NoOverrideEqualsClass {
    public String name;

    NoOverrideEqualsClass(String name) {
        this.name = name;
    }
}

class OverrideEqualsClass {
    public String name;
    public int age;

    OverrideEqualsClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof OverrideEqualsClass) {
            OverrideEqualsClass o1 = (OverrideEqualsClass) o;
            // 这里使用Objects.equals因为x.equals(y)要求x不等于null, 直接使用Object.equals可省略很多判断
            if (Objects.equals(this.name, o1.name) && this.age == o1.age) {
                return true;
            }
        }
        return false;
    }
}
