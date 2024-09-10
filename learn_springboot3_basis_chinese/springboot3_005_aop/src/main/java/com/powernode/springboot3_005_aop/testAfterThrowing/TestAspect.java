package com.powernode.springboot3_005_aop.testAfterThrowing;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("testAspect3")
@Aspect
public class TestAspect {
    // 只有抛出异常后(且该异常没有被try catch)才会被执行，没异常不执行
    @AfterThrowing("execution(* com.powernode.springboot3_005_aop.testAfterThrowing.TestController.*(..))")
    public void beforeAdvice() {
        System.out.println("throwing Advice@@@@@");
    }
}
