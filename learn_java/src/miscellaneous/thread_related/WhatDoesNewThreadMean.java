package miscellaneous.thread_related;

public class WhatDoesNewThreadMean {
    public static void main(String[] args) {
        // new Thread相当于创建了一个匿名类实例，此匿名类继承自Thread，代码块中的是run方法
        Thread t = new Thread(() -> {
            System.out.println("thread hello");
        });
        t.start();
        System.out.println("main hello");
    }
}
