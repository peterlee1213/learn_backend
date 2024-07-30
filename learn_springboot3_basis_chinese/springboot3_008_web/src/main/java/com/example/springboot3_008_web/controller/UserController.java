package com.example.springboot3_008_web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot3_008_web.domain.User;
import com.example.springboot3_008_web.repositories.UserRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController("userController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 查询
    @GetMapping("/{id}")
    public Optional<User> getMethodName(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    // 新增
    @PostMapping
    public void save(@RequestBody User user) {
        userRepository.save(user);
    }

    // 修改
    @PutMapping
    public void update(@RequestBody User user) {
        userRepository.save(user);
    }

    // 删除
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

}
