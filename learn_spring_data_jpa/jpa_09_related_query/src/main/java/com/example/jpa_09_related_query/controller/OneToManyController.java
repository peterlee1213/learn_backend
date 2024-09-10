package com.example.jpa_09_related_query.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa_09_related_query.domains.Student;
import com.example.jpa_09_related_query.domains.StudentClass;
import com.example.jpa_09_related_query.repositories.StudentClassRepository;

import jakarta.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用Student和StudentClass
 */
@RestController
@RequestMapping("/9")
public class OneToManyController {

    @Resource
    private StudentClassRepository studentClassRepository;

    /**
     * 测试查询
     * 
     * 查询会将这个class对应的学生全部查询出来放到students属性中
     * 
     * @return
     */
    @GetMapping("/oneToManyQuery")
    public List<StudentClass> query() {
        List<StudentClass> list = studentClassRepository.findAll();
        return list;
    }

    /**
     * 测试新增
     * 
     * 会将一个class和它对应的多个学生同时插入StudentClass表和student表中
     */
    @GetMapping("oneToManyInsert")
    @Transactional
    public void insert() {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student();
        student1.setName("qianqi");
        Student student2 = new Student();
        student2.setName("jiaba");

        students.add(student1);
        students.add(student2);

        StudentClass studentClass = new StudentClass();
        studentClass.setName("class three");
        studentClass.setStudents(students);

        studentClassRepository.save(studentClass);

    }

    /**
     * 删除测试
     * 
     * 删除一个班级同时会删除对应的所有学生
     */
    @GetMapping("oneToManyDelete")
    @Transactional
    public void delete() {
        studentClassRepository.deleteById(5L);
    }

}
