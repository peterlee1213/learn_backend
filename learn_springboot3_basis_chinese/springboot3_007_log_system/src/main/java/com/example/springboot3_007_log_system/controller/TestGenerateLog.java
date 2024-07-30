package com.example.springboot3_007_log_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/7")
public class TestGenerateLog {

    private Logger logger = LoggerFactory.getLogger(TestGenerateLog.class);

    @GetMapping("testGenerateLog")
    public String getMethodName() {
        for (int i = 0; i <= 50000; i++) {
            logger.trace("trace");
            logger.debug("debug");
            logger.info("info");
            logger.warn("warn");
            logger.error("error");
        }
        return new String("hello");
    }

}
