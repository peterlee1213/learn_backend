package com.powernode.springboot3_005_aop.testAround;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("testController2")
@RequestMapping("/5")
public class TestController {
    @GetMapping("testAroundAdvice1")
    public void testAroundAdvice1() {
        System.out.println("testAroundAdvice1");
    }

    @GetMapping("testAroundAdvice2")
    public void testAroundAdvice2() {
        System.out.println("testAroundAdvice2");
    }
}
