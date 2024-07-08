package _8_collection;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 集合/使用PriorityQueue
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265120632401152#0
 */
public class UsePriorityQueue_10 {
    public static void main(String[] args) {
        simpleUseCaseForPriorityQueue();
    }

    // PriorityQueue的简单实用方式: 默认情况下优先级根据元素的Comparable来判断
    public static void simpleUseCaseForPriorityQueue() {
        Queue<String> q = new PriorityQueue<>();
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");
        System.out.println(q.poll()); // apple
        System.out.println(q.poll()); // banana
        System.out.println(q.poll()); // pear
    }
}
