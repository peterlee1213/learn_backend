package _12_multi_thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.Scanner;

/**
 * 多线程/使用Concurrent集合
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306581060812834
 */
public class UseConcurrent_13 {
    public static void main(String[] args) {
        DealWithQueue t = new DealWithQueue();
        t.start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("say something: ");
            String temp = scanner.nextLine();
            try {
                MyLock.wlock.lock();
                t.q.put(temp);
                t.q.notifyAll();
            } catch (InterruptedException e) {
                scanner.close();
            } finally {
                MyLock.wlock.unlock();
            }
        }
    }
}

class MyLock {
    public static final ReadWriteLock lock = new ReentrantReadWriteLock();
    public static final Lock rlock = lock.readLock();
    public static final Lock wlock = lock.writeLock();
}

class DealWithQueue extends Thread {
    public volatile LinkedBlockingDeque<String> q = new LinkedBlockingDeque<>();

    public void run() {
        while (true) {
            MyLock.rlock.lock();
            while (q.isEmpty()) {
                try {1
                    q.wait();
                } catch (InterruptedException e) {
                    MyLock.rlock.unlock();
                } finally {
                }
            }
            System.out.println(q.poll());
        }
    }
}
