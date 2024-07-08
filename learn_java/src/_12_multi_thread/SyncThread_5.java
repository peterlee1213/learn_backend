package _12_multi_thread;

/**
 * 多线程/线程同步
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306580844806178
 */
public class SyncThread_5 {
    public static void main(String[] args) throws Exception {
        // whyWeNeedSyncThread();
        lockUseCaseInMultiThreads();
    }

    // 为什么我们需要线程同步
    // 按理来说下面的count应该始终为0, 但是事实不是如此
    public static void whyWeNeedSyncThread() throws Exception {
        var add = new AddThread();
        var dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }

    // 线程锁的使用方式
    public static void lockUseCaseInMultiThreads() throws Exception {
        var add = new AddThreadWithLock();
        var dec = new DecThreadWithLock();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }
}

class Counter {
    // 这不是线程共享变量，是static变量，所以用不着volatile关键字
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Counter.count += 1;
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Counter.count -= 1;
        }
    }
}

class CounterWithLock {
    // 每一把锁应该代表不能互相冲突的一个或一组资源
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThreadWithLock extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (CounterWithLock.lock) {
                CounterWithLock.count++;
            }
        }
    }
}

class DecThreadWithLock extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (CounterWithLock.lock) {
                CounterWithLock.count--;
            }
        }
    }
}
