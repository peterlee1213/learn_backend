package _8_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 集合/使用Collections
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1299919855943714#0
 */
public class UseCollections_13 {
    public static void main(String[] args) {
        // Collections提供了操作集合(List, Map, Set)的一系列方法
        sortUseCase();
        shuffleUseCase();
    }

    // 对集合进行排序,会直接改变源对象
    public static void sortUseCase() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("orange");
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
    }

    // 对集合打乱顺序, 会直接 改变源对象
    public static void shuffleUseCase() {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        Collections.shuffle(l);
        System.out.println(l);
    }
}
