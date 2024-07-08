package _12_multi_thread;

/**
 * 多线程/中断线程
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306580767211554
 */
public class InterruptThread_3 {
    public static void main(String[] args) throws InterruptedException {
        // interruptExample();
        // joinReceiveInterrupt();
        interruptWithVolatile();
    }

    // 基本使用方法
    public static void interruptExample() throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1); // 当前main线程暂停1ms
        t.interrupt(); // 向t所代表的线程发送interrupt请求, 并不直接粗暴地终止线程，具体如何操作要看线程代码如何写的
        t.join(); // 等待t线程结束
        System.out.println("end");
    }

    // 如果一个线程正处于join()状态等待其他线程，此时收到interrupt(),则join()方法会直接跑出InterruptedException并继续向下执行
    public static void joinReceiveInterrupt() throws InterruptedException {
        MyThread1 t = new MyThread1();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
        System.out.println("main end");
    }

    // 使用标志位中断线程
    public static void interruptWithVolatile() throws InterruptedException {
        VolatileThread t = new VolatileThread();
        t.start();
        Thread.sleep(2);
        t.running = false;
        System.out.println("main end");
    }
}

class MyThread extends Thread {
    public void run() {
        int n = 0;
        // 判断是否有中断信号传来
        while (!isInterrupted()) {
            n++;
            System.out.println(n);
        }
    }
}

class MyThread1 extends Thread {
    public void run() {
        Thread hello = new HelloThread();
        hello.start();
        try {
            // join状态收到interrupt()会立刻结束join状态
            hello.join();
        } catch (InterruptedException e) {
            System.out.println("MyThread1 interrupted");
        }
        hello.interrupt();
        System.out.println("mythread1 end");
    }
}

class HelloThread extends Thread {
    public void run() {
        int n = 0;
        while (true) {
            n++;
            System.out.println(n + " Hello");
            try {
                // Thread.sleep接收到interrupt()会立刻停止睡眠状态并抛出InterruptedException
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Hello Interrupted");
                break;
            }
        }
        System.out.println("hello thread end");
    }
}

class VolatileThread extends Thread {
    // volatile定义线程间共享变量，此关键字可确保其他线程获取到此变量的值永远是最新的，否则可能会有滞后性，即A线程更新了此变量的值但是B线程读取的还是原先的值
    public volatile boolean running = true;

    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + " hello");
        }
        System.out.println("Volatile thread end");
    }
}