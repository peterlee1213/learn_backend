package _12_multi_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程/使用线程池
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306581130018849
 */
public class UseThreadPool_14 {
    // 线程池基本使用方式
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        es.shutdown();
    }
}

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task: " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("end task: " + name);
    }
}