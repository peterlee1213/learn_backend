package _8_collection;

import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 集合/使用Queue
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265121791832960
 */
public class UseQueue_9 {
    public static void main(String[] args) {
        // 队列Queue只有两个操作
        // 1. 把元素添加到队列末尾
        // 2. 从队列头部取出元素
        commonUseCase();
    }

    public static void commonUseCase() {
        Queue<String> q = new LinkedList<>();
        System.out.println(q.size()); // 0

        // 添加元素
        try {
            q.add("abc");
        } catch (IllegalStateException e) {
            // 添加失败会throw error
        }

        if (q.offer("def")) {

        } else {
            // 添加失败会返回false或null
        }

        System.out.println(q.size()); // 2

        // 取队首元素但不删除
        try {
            System.out.println(q.element());
        } catch (NoSuchElementException e) {
            // 队列为空会throw error
        }

        if (q.peek() == null) {
            // 队列为空取出失败时会返回false或null
        }

        // 取队首元素并删除
        try {
            System.out.println(q.remove());
        } catch (IllegalStateException e) {
            // 队列为空取出失败会报错
        }
        String a = q.poll();
        if (a == null) {
            // 取出失败会返回false或null
        }
        System.out.println(a);
    }
}
