package com.example.jpa_09_related_query.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa_09_related_query.domains.Company;
import com.example.jpa_09_related_query.domains.Employee;
import com.example.jpa_09_related_query.repositories.EmployeeRepository;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用Company和Employee
 */
@RestController
@RequestMapping("/9")
public class ManyToOneController {

    @Resource
    private EmployeeRepository employeeRepository;

    /**
     * 测试新增
     * 
     * 会级联插入company
     */
    @GetMapping("manyToOneInsert")
    @org.springframework.transaction.annotation.Transactional
    public void insert() {
        Company company = new Company();
        company.setComName("xiaomi");

        Employee employee = new Employee();
        employee.setEmpName("leijun");
        employee.setCompany(company);

        employeeRepository.save(employee);
    }

    /**
     * 测试连续新增多条
     * 
     * 可看到在这种多对一的批量插入中，company只被插入了一条
     */
    @GetMapping("manyToOneInsertBatch")
    @org.springframework.transaction.annotation.Transactional
    public void insertBatch() {
        Company company = new Company();
        company.setComName("xiaomi");

        Employee employee1 = new Employee();
        employee1.setEmpName("leijun");
        employee1.setCompany(company);
        Employee employee2 = new Employee();
        employee2.setEmpName("jinfan");
        employee2.setCompany(company);

        ArrayList<Employee> arrayList = new ArrayList<Employee>();
        arrayList.add(employee1);
        arrayList.add(employee2);

        employeeRepository.saveAll(arrayList);
    }

    /**
     * 测试删除
     * 删除employee会级联删除对应的company吗？
     * 如果这个company还有其他employee通过外键连接着，就会报错然后删除失败，因为同样的company的id还有其他employee在用着
     * 如果这个employee是引用这个company的id的最后一个，则可以级联删除成功
     */
    @GetMapping("manyToOneDelete")
    @org.springframework.transaction.annotation.Transactional
    public void delete() {
        employeeRepository.deleteById(5L);
    }

    /**
     * 测试查询
     * 
     * 可以级联查询出来
     */
    @GetMapping("manyToOneQuery")
    public Optional<Employee> query() {
        return employeeRepository.findById(1L);
    }

}
