package com.powernode.jdkdynamicproxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        // 创建目标对象
        OrderService target = new OrderServiceImpl();
        // 创建代理对象
        /*
         * 1. newProxyInstance 调用这个方法可以在内存中创建代理对象,本质上它的执行做了两件事儿
         * (1) 在内存中动态生成了一个代理类的字节码
         * (2) 通过上述(1)中的代理类new对象了
         * 2. 三个参数
         * (1)ClassLoader loader
         * 类加载器,内存中生成的字节码也是class文件,要执行也得加载到内存中,加载类就需要类加载器,所以这里要指定类加载器
         * 并且JDK要求,目标类必须和代理类的类加载器相同
         * (2)Class<?>[] interfaces
         * 代理类和目标类要实现同一个或同一些接口
         * (3)InvocationHandler h
         * 在调用处理器接口中编写的就是增强代码,既然是接口,就要写接口的实现类,只需要写一个实现类即可,不会类爆炸
         * 
         * 注意:代理对象和目标对象会实现相同的接口,所以可安全地向下转型
         */
        OrderService proxy = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new TimerInvocationHandler(target));
        // 调用代理对象的代理方法
        proxy.modify();
        proxy.detail();
        proxy.generate();
    }
}
