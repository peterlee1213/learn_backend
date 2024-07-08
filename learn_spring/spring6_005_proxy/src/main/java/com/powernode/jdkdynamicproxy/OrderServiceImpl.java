package com.powernode.jdkdynamicproxy;

public class OrderServiceImpl implements OrderService {

    @Override
    public void detail() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("order detail");
    }

    @Override
    public void generate() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("order generated");
    }

    @Override
    public void modify() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("order modified");
    }

    public void unique() {
        System.out.println("unique method");
    }

}
