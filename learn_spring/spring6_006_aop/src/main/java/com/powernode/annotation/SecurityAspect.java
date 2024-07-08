package com.powernode.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SecurityAspect {
    // 也可以跨类引用通用切点,这样的话就必须写全限定名称
    @Before("com.powernode.annotation.LogAspect.commonPointCut()")
    public void beforeSceurityAspect() {
        System.out.println("前置通知:安全通知");
    }
}
