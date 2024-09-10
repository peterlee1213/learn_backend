package com.powernode.springboot3_005_aop.testAfter;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("testAspect4")
@Aspect
public class TestAspect {
    // 最终通知不管程序正常执行后返回（@AfterReturning）还是抛出异常（@AfterThrowing）都会正常执行
    @After("execution(* com.powernode.springboot3_005_aop.testAfter.TestController.*(..))")
    public void afterAdvice() {
        System.out
                .println("after Advice@@@@@, will be executed regardless of the procedure throws an exception or not");
    }
}
