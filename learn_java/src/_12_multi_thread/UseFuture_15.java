package _12_multi_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多线程/使用Future
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306581155184674
 */
public class UseFuture_15 {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        // 定义任务
        Callable<String> task = new Task();
        // 提交任务并获得future
        Future<String> future = executor.submit(task);
        // 从Future获得一部执行返回的结果，如果没有返回会一直阻塞在这里
        String result = future.get();
        System.out.println(result);
        executor.shutdown();
    }
}

class Task implements Callable<String> {
    public String call() throws Exception {
        return "hello";
    }
}