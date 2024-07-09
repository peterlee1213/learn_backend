package _12_multi_thread;

/**
 * 多线程/守护线程
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306580788183074
 */
public class DaemonThread_4 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        // 守护进程会一直在后台运行，不需要停止，最后一个非守护进程结束之后所有守护进程会自动停止
        t.setDaemon(true); // 设置进程为守护进程
        t.start();
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("hello");
    }
}