package com.powernode.springboot3_005_aop.testBefore;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeAspect {

    @Before("execution(* com.powernode.springboot3_005_aop.testBefore.TestController.*(..))")
    public void beforeAdvice() {
        System.out.println("before advice weaving into testBeforeAdvice*");
    }
}
