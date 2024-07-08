package com.powernode.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect // 切面类这里必须要加这个注解s
@Order(2)
public class LogAspect { // 切面
    // 切面 = 通知 + 切点

    // 定义通用切点表达式
    @Pointcut("execution(* com.powernode.annotation.UserService.*(..))")
    public void commonPointCut() {
    }

    // 前置通知
    @Before("commonPointCut()")
    public void enhance(JoinPoint jp) {
        System.out.println("Before 通知");
        System.out.println(jp.getSignature());
    }

    // 后置通知
    @AfterReturning("execution(* com.powernode.annotation.UserService.*(..))")
    public void afterAspect() {
        System.out.println("AfterReturning 通知");
    }

    // 环绕通知
    // 环绕是最大的通知,在前置通知之前,后置通知之后
    @Around("execution(* com.powernode.annotation.UserService.*(..))")
    public void aroundAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前篇的通知
        System.out.println("Around 前环绕");

        // 目标方法
        joinPoint.proceed();

        // 后面的通知
        System.out.println("Around 后环绕");
    }

    // 异常通知
    // 注意: 在异常中后置通知和后环绕不执行
    @AfterThrowing("execution(* com.powernode.annotation.UserService.*(..))")
    public void afterThrowingAspect() {
        System.out.println("AfterThrowing 通知");
    }

    // 最终通知
    @After("execution(* com.powernode.annotation.UserService.*(..))")
    public void finalAspect() {
        System.out.println("After 通知");
    }
}
