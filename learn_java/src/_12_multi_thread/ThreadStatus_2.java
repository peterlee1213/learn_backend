package _12_multi_thread;

/**
 * 多线程/线程的状态
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306580742045730
 */
public class ThreadStatus_2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        });
        System.out.println("start");
        t.start();
        // join方法可确保t执行完毕之后再继续执行主线程(main方法)
        t.join();
        System.out.println("end");
    }
}
