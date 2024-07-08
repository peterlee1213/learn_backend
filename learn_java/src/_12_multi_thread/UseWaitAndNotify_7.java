package _12_multi_thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

/**
 * 多线程/使用wait和notify
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306580911915042
 */
public class UseWaitAndNotify_7 {
    public static void main(String[] args) throws InterruptedException {
        var q = new TaskQueue();
        var ts = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                // 执行task
                while (true) {
                    try {
                        String s = q.getTask();
                        System.out.println("Thread " + i + " execute task: " + s);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            t.start();
            ts.add(t);
        }
        var add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);
        for (var t : ts) {
            t.interrupt();
        }
    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (this.queue.isEmpty()) {
            this.wait();
        }

        return queue.remove();
    }
}