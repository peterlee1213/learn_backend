package com.powernode.springboot3_005_aop.testAround;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("testAspect1")
@Aspect
public class TestAspect {
    @Around("execution(* com.powernode.springboot3_005_aop.testAround.TestController.*(..))")
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("Around Advices Before!!!!!!!!!!!!!!!!!!!!!");

        pjp.proceed();

        System.out.println("Around Advices after!!!!!!!!!!!!!!!!!!!!!");
    }
}
