package _8_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 集合/使用List
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265112034799552#0
 */
public class List_1 {
    public static void main(String[] args) {
        listDemo();
        createListFromOfMethod();
        commonWayIterateThroughList();
        iteratorThroughList();
        forEachIteratorThroughList();
    }

    // List允许我们添加重复的元素
    public static void listDemo() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("apple");
        System.out.println(list.size());
    }

    // 使用List的of方法创建List
    public static void createListFromOfMethod() {
        List<Integer> list = List.of(1, 2, 5);
        System.out.println(list.size());
    }

    // 遍历List的一般且不推荐的方法
    public static void commonWayIterateThroughList() {
        List<Integer> list = new LinkedList<>();
        list.add(12);
        list.add(24);
        list.add(67);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // 使用Iterator高效遍历特定对象
    public static void iteratorThroughList() {
        List<String> list = List.of("apple", "pear", "banana");
        for (Iterator<String> it = list.iterator(); it.hasNext();) {
            String s = it.next();
            System.out.println(s);
        }
    }

    // for each循环本身就使用Iterator帮我们遍历的
    public static void forEachIteratorThroughList() {
        List<String> list = List.of("apple", "pear", "banana");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
