package _8_collection;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

/**
 * 集合/使用Set
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265121225603904#0
 */
public class UseSet_8 {
    public static void main(String[] args) {
        simpleUseCase();
        treeSetUseCase();
        comparableSetUseCase();
    }

    // 简单的使用例子
    public static void simpleUseCase() {
        Set<String> set = new HashSet<>();
        System.out.println(set.add("abc"));
        System.out.println(set.add("xyz"));
        System.out.println(set.add("xyz")); // false, 因为元素已经存在
        System.out.println(set.contains("xyz")); // true
        System.out.println(set.remove("abc")); // true
        System.out.println(set.size()); // 1
    }

    // TreeSet是有序集合
    public static void treeSetUseCase() {
        Set<String> set = new TreeSet<>();
        set.add("apple");
        set.add("banana");
        set.add("pear");
        set.add("orange");
        for (String s : set) {
            System.out.println(s);
        }
    }

    // TreeSet和实现对集合元素的排序, 集合元素必须实现Comparable接口,否则就必须在创建Treeset时传入一个Comparator.
    public static void comparableSetUseCase() {
        Set<ComparableClass8> set = new TreeSet<>();
        set.add(new ComparableClass8(2));
        set.add(new ComparableClass8(1));
        set.add(new ComparableClass8(6));
        set.add(new ComparableClass8(4));
        for (ComparableClass8 c : set) {
            System.out.println(c.age);
        }
    }
}

class ComparableClass8 implements Comparable<ComparableClass8> {
    int age;

    ComparableClass8(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(ComparableClass8 c) {
        return this.age - c.age;
    }
}