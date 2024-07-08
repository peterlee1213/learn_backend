package com.powernode.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 在这里编写增强代码
 */
public class TimerInvocationHandler implements InvocationHandler {

    private OrderService orderService;

    public TimerInvocationHandler(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 1. 调用invoke方法的代码已经写好了
     * 2. invoke什么时候被调用呢
     * 当代理对象调用代理方法(在interface中定义的方法)的时候
     */
    /*
     * invoke方法的三个参数
     * 1. Object proxy 代理对象的引用
     * 2. Method method 目标对象上的目标方法
     * 3. Object[] args 目标方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        // 调用目标对象上的目标方法
        // 方法四要素: 哪个对象/哪个方法/传什么参数/返回什么结果
        // 目标对象得传过来, 所以需要一个构造方法以及一个OrderService类型的变量
        Object retValuObject = method.invoke(orderService, args);
        long end = System.currentTimeMillis();
        System.out.println("total time:" + (end - start));
        // 这里应该返回调用目标方法之后的返回值
        return retValuObject;
    }

}
