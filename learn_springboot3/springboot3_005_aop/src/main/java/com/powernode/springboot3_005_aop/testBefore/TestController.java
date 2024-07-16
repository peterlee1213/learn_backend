package com.powernode.springboot3_005_aop.testBefore;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/5")
public class TestController {

    @GetMapping("testBeforeAdvice1")
    public void testBeforeAdvice1() {
        System.out.println("the pointcut that being weaved into [before] advice, testBeforeAdvice1");
    }

    @GetMapping("testBeforeAdvice2")
    public void testBeforeAdvice2() {
        System.out.println("the pointcut that being weaved into [before] advice, testBeforeAdvice2");
    }

}
