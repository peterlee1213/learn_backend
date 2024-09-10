package com.example.jpa_09_related_query.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa_09_related_query.domains.Account;
import com.example.jpa_09_related_query.domains.Customer;
import com.example.jpa_09_related_query.repositories.CustomerRepository;

import jakarta.annotation.Resource;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用Customer和Account
 * 测试单向一对一的增删改查
 * 单向一对一是指只在一个Entity中配置对应关系而在另一个Entity类中什么都不配置，本例子中即
 * Customer中配置与Account的对应关系，但是在Account中什么都不做
 */
@RestController
@RequestMapping("/9")
public class OneWayOneToOneController {

    @Resource
    private CustomerRepository customerRepository;

    /**
     * 多表关联新增
     * 只要向Customer中新增，且Customer中含有Account对象，则Account会一并新增，并且Customer中的account_id会在Account插入之后关联更新
     * 需要在Customer的Entity类中添加CascadeType.PERSIST
     */
    @GetMapping("/oneWayOneToOneInsert")
    @Transactional
    public void insert() {

        Account account = new Account();
        account.setUsername("tanaka_net_name");
        account.setPassword("123456");

        Customer customer = new Customer();
        customer.setCustAddress("Osaka");
        customer.setCustName("Tanaka Ichiro");
        customer.setAccount(account);

        customerRepository.save(customer);
    }

    /**
     * 多表关联查询
     * 查询不需要在Entity中设置任何关联操作，这是自动的
     */
    @GetMapping("/oneWayOneToOnequery")
    @Transactional(readOnly = true)
    public List<Customer> query() {
        List<Customer> list = customerRepository.findAll();
        list.forEach(listItem -> {
            System.out.println(listItem);
        });
        return list;
    }

    /**
     * 多表关联删除
     * 只要删除Customer的Entity,Account中的对应Entity也会关联删除
     * 前提是配置CascadeType.REMOVE
     */
    @GetMapping("/oneWayOneToOnedelete")
    @Transactional
    public void delete() {
        customerRepository.deleteById(5L);
    }

}
