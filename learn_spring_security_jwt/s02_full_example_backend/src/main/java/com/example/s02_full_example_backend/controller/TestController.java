package com.example.s02_full_example_backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.s02_full_example_backend.entities.ExampleUser;
import com.example.s02_full_example_backend.repositories.ExampleUserRepository;

import jakarta.annotation.Resource;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private ExampleUserRepository exampleUserRepository;

    // 测试数据库连接是否有问题
    @GetMapping("/repository_connectivity")
    public Optional<ExampleUser> testDbConnectivity() {
        return exampleUserRepository.findByUserName("admin");
    }

}
