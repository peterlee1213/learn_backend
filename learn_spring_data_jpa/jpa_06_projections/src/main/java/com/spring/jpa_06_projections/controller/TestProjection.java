package com.spring.jpa_06_projections.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa_06_projections.dto.EmployeeName;
import com.spring.jpa_06_projections.jpainterfaces.ClassBasedProjectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/6")
public class TestProjection {

    @Autowired
    private ClassBasedProjectionRepository cbpr;

    @GetMapping("testClassBased")
    public void getMethodName() {
        EmployeeName obj = cbpr.findByEmpNo(1);
        System.out.println(obj);
    }

}
