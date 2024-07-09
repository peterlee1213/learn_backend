package _12_multi_thread;

/**
 * 多线程/同步方法
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306580867874849
 */
public class SyncMethod_6 {
    public static void main(String[] args) throws Exception {
        // 对方法添加synchronized表示同一个实例带有此标志的方法不能多线程同时执行
        // 同一个类不同实例的带有synchronized的方法可同时执行
    }
}

// 此类跟CounterSynchronized完全相同
class Counter extends Thread {
    private int counter = 0;

    public synchronized void add() {
        this.counter++;
    }

    public synchronized void dec() {
        this.counter--;
    }

    public int getCounter() {
        return this.counter;
    }
}

// 此类跟Counter完全相同
class CounterSynchronized extends Thread {
    private int counter = 0;

    public void add() {
        synchronized (this) {
            this.counter++;
        }
    }

    public void dec() {
        synchronized (this) {
            this.counter--;
        }
    }

    public int getCounter() {
        return this.counter;
    }
}