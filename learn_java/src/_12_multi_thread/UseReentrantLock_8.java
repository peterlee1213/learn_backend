package _12_multi_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程/使用ReentrantLock
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306580960149538
 */
public class UseReentrantLock_8 {
    public static void main(String[] args) {

    }
}

// ReentrantLock的基本使用方式
class Counter {
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) {
        lock.lock();
        try {
            this.count += n;
        } finally {
            lock.unlock();
        }
    }
}