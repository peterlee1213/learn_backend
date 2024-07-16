package com.powernode.springboot3_005_aop.testAfterThrowing;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("testController3")
@RequestMapping("/5")
public class TestController {
    @GetMapping("testAfterThrowingAdvice1")
    public void testAfterThrowingAdvice1() {
        System.out.println("testAfterThrowingAdvice1, throwing an exception");
        String s = null;
        s.toString();
    }

    @GetMapping("testAfterThrowingAdvice2")
    public void testAfterThrowingAdvice2() {
        System.out.println("testAfterThrowingAdvice2, not throwing an exception");
    }
}
