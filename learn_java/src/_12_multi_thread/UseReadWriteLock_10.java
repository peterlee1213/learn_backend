package _12_multi_thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多线程/使用ReadWriteLock
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306581002092578
 */
public class UseReadWriteLock_10 {
    public static void main(String[] args) {

    }
}

// 读写锁的使用案例
class Counter {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock rlock = rwLock.readLock();
    private final Lock wlock = rwLock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        wlock.lock();
        try {
            counts[index] = +1;
        } finally {
            wlock.unlock();
        }
    }

    public int[] get() {
        rlock.lock();
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock();
        }
    }
}