package com.powernode.example;

public class Guest {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        OrderService orderServiceProxy = new OrderServiceProxy(orderService);

        orderServiceProxy.detail();
        orderServiceProxy.generate();
        orderServiceProxy.modify();
    }
}
