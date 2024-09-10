package com.powernode.springboot3_005_aop.testAfterReturning;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("testController1")
@RequestMapping("/5")
public class TestController {
    @GetMapping("testAfterReturningAdvice1")
    public void testAfterReturningAdvice1() {
        System.out.println("the pointcut that being weaved into [before] advice, testAfterReturningAdvice1");
    }

    @GetMapping("testAfterReturningAdvice2")
    public void testAfterReturningAdvice2() {
        System.out.println("the pointcut that being weaved into [before] advice, testAfterReturningAdvice2");
    }
}
