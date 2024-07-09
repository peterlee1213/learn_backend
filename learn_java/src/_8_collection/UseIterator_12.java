package _8_collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 集合/使用Iterator
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265124784468736
 */
public class UseIterator_12 {
    public static void main(String[] args) {
        IterableClass<String> rlist = new IterableClass<>();
        rlist.add("apple");
        rlist.add("orange");
        rlist.add("pear");
        for (Iterator<String> it = rlist.iterator(); it.hasNext();) {
            String s = it.next();
            System.out.println(s);
        }
        // 上述for循环等同于以下代码
        for (String s : rlist) {
            System.out.println(s);
        }
    }
}

/**
 * 自定义集合类只要满足以下条件就可使用for each循环
 * 1. 集合类实现Iterable接口
 * 2. 用Iterator对象迭代集合内部数据
 */
class IterableClass<T> implements Iterable<T> {
    private List<T> list = new ArrayList<>();

    public void add(T t) {
        list.add(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator(list.size());
    }

    class ReverseIterator implements Iterator<T> {
        int index;

        ReverseIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return IterableClass.this.list.get(index);
        }
    }
}