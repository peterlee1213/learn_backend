package com.powernode.example;

public class OrderServiceProxy implements OrderService {

    private OrderService orderService;

    public OrderServiceProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void detail() {
        long start = System.currentTimeMillis();
        orderService.detail();
        long end = System.currentTimeMillis();
        System.out.println("time " + (end - start));

    }

    @Override
    public void generate() {
        long start = System.currentTimeMillis();
        orderService.generate();
        long end = System.currentTimeMillis();
        System.out.println("time " + (end - start));
    }

    @Override
    public void modify() {
        long start = System.currentTimeMillis();
        orderService.modify();
        long end = System.currentTimeMillis();
        System.out.println("time " + (end - start));
    }

}
