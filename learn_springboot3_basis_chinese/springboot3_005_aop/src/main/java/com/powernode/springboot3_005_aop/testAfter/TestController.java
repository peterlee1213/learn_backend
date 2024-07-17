package com.powernode.springboot3_005_aop.testAfter;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("testController4")
@RequestMapping("/5")
public class TestController {
    @GetMapping("testAfterAdvice1")
    public void testAfterAdvice1() {
        System.out.println("testAfterAdvice1, throwing an exception");
        String s = null;
        s.toString();
    }

    @GetMapping("testAfterAdvice2")
    public void testAfterAdvice2() {
        System.out.println("testAfterAdvice2, not throwing an exception");
    }
}
