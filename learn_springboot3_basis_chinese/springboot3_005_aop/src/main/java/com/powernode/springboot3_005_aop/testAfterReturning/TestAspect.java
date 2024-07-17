package com.powernode.springboot3_005_aop.testAfterReturning;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {
    @AfterReturning("execution(* com.powernode.springboot3_005_aop.testAfterReturning.TestController.*(..))")
    public void beforeAdvice() {
        System.out.println("AfterReturning Advices!!!!!!!!!!!!!!!!!!!!!");
    }
}
