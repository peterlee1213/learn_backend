package com.example.jpa_09_related_query.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa_09_related_query.repositories.OptimisticLockRepository;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/9")
public class OptimisticLockController {

    @Resource
    private OptimisticLockRepository optimisticLockRepository;

    @GetMapping("/optimisticlockupdatetest")
    public void getMethodName() {

    }

}
