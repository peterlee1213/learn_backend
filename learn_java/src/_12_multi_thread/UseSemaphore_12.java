package _12_multi_thread;

import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 多线程/使用Semaphore
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1501424189964323
 */
public class UseSemaphore_12 {
    public static void main(String[] args) {

    }
}

class AccessLimitControl {
    // 任何时刻最多允许三个线程获得许可
    private final Semaphore semaphore = new Semaphore(3);

    public String access() throws Exception {
        // 如果超过了许可数量，其他线程将在此等待
        semaphore.acquire();
        try {
            return UUID.randomUUID().toString();
        } finally {
            semaphore.release();
        }
    }

    public String tryAccess() throws Exception {
        // 等待最多3s获取锁
        if (semaphore.tryAcquire(3, TimeUnit.SECONDS)) {
            try {
                return UUID.randomUUID().toString();
            } finally {
                semaphore.release();
            }
        }
        return "";
    }
}
