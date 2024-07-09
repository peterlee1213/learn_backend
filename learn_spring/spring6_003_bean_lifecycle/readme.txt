bean的5步生命周期

1. 实例化bean(调用constructor)
2. bean属性赋值(set注入)
3. 初始化bean(调用Bean的init方法,这个方法要自己写自己配)
4. 使用bean
5. 销毁bean(调用Bean的destroy方法,这个方法要自己写自己配)

bean的7步生命周期(在第三步之前和之后插入,对应的类要实现BeanPostProcessor接口)

1. 实例化bean(调用constructor)
2. bean属性赋值(set注入)
2.5 
3. 初始化bean(调用Bean的init方法,这个方法要自己写自己配)
3.5
4. 使用bean
5. 销毁bean(调用Bean的destroy方法,这个方法要自己写自己配)

注意事项:
1. Spring只对singleton进行完整的生命周期管理,对于prototype, 一旦客户端程序获取到Bean之后, Spring容器就不再管理该对象的生命周期了