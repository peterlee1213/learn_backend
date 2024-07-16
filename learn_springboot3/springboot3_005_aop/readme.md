在SpringBoot中使用aop需要先添加aop的starter
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

---

terms:

JoinPoint(连接点)
In the whole procedure of execution of program, the point that you can wave into an advice
在程序整个执行流程中，可以织入切面的位置

Pointcut(切点)
被织入切面的方法

通知（advice）
增强代码
+ 前置通知 @Before
+ 后置通知 @AfterReturning  程序流程全部执行完毕之后再执行，程序throw exception之后不再执行
+ 环绕通知 @Around          程序throw exception之后不再执行后半部分通知
+ 异常通知 @AfterThrowing   throw an exception之后才执行，而且此exception不能被catch
+ 最终通知 @After           不管程序是否throw an exception都会执行

切面（Aspect）
@Aspect标注在类上表示这个类是一个切面类
切点+通知
