package com.spring.jpa_05_jpa_query_methods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa_05_jpa_query_methods.repositories.QueryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/5")
public class QueryMethodController {

    @Autowired
    private QueryRepository qr;

    /**
     * 测试手写更新JPQL
     */
    @GetMapping("testUpdate")
    @Transactional
    public void getMethodName() {
        int result = qr.updateFirstNameById("Mogan", 1);
        qr.flush();
        System.out.println(result);
        System.out.println(qr.findById(1));
    }

    /**
     * 测试自带删除JPQL
     */
    @GetMapping("/testAutomateDelete")
    @Transactional
    public void test1() {
        qr.deleteByEmpNo(17);
    }

    /**
     * 测试手写JPQL
     */
    @GetMapping("/testHandWritingDelete")
    @Transactional
    public void test2() {
        qr.deleteByEmpNoWithQuery(18);
    }
}
