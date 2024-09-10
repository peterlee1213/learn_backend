package com.spring.jpa_04_define_query_methods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa_04_define_query_methods.repository.DeriveQueryFromMethodNameRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("4")
public class DeleteController {

    @Autowired
    private DeriveQueryFromMethodNameRepository repository;

    @Transactional
    @GetMapping("testDeleteWithMethodNameResolve")
    public void getMethodName() {
        System.out.println(repository.deleteByEmpNo(1));
    }

}
