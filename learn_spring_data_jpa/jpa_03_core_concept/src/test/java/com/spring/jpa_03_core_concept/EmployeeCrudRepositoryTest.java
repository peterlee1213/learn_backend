package com.spring.jpa_03_core_concept;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.spring.jpa_03_core_concept.domain.Employees;
import com.spring.jpa_03_core_concept.enumclass.Gender;
import com.spring.jpa_03_core_concept.jpainterfaces.EmployeeCrudRepository;

import jakarta.transaction.Transactional;

import java.text.DateFormat;
import java.text.ParseException;

@SpringBootTest
public class EmployeeCrudRepositoryTest {
    @Autowired
    private EmployeeCrudRepository ecr;

    /**
     * 测试CrudRepository中的save方法
     * 
     * @throws ParseException
     */
    @Test
    @Transactional
    public void testSave() throws ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = sdf.parse("2000-01-01");
        Date hireDate = sdf.parse("2023-01-01");
        Employees employees = new Employees(
                null,
                birthDate,
                "Joe",
                "Biden",
                Gender.M,
                hireDate);
        ecr.save(employees);
    }

    /**
     * 测试CrudRepository中的findAll方法
     */
    @Test
    public void testFindAll() {
        System.out.println(ecr.findAll());
    }

    /**
     * 测试CrudRepository中的deleteById方法
     */
    @Test
    public void testDeleteById() {
        ecr.deleteById(15);
    }

}
