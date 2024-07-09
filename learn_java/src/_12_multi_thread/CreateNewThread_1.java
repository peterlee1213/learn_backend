package _12_multi_thread;

/**
 * 多线程/创建多线程
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306580710588449
 */
public class CreateNewThread_1 {
    public static void main(String[] args) {
        basicUseCase();
        createThreadWithClassImplementRunnable();
    }

    // 线程最简单的例子
    // 这两个线程的执行完成顺序不一定按照代码书写顺序
    public static void basicUseCase() {
        Thread t = new MyThread();
        t.setPriority(5); // 设置优先级，1（低）~10（高）
        t.start(); // 启动新线程 start()就是调用实例的run()
        Thread t1 = new MyThread1();
        t1.start(); // 启动新线程
    }

}

// 继承Thread类并在类内部override run方法
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread1111!");
    }
}
