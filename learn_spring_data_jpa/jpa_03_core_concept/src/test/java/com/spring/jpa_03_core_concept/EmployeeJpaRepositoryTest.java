package com.spring.jpa_03_core_concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.jpa_03_core_concept.domain.Employees;
import com.spring.jpa_03_core_concept.jpainterfaces.EmployeeJpaRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class EmployeeJpaRepositoryTest {

    @Autowired
    private EmployeeJpaRepository ejr;

    /**
     * 测试JpaRepository中的getReferenceById
     */
    @Test
    @Transactional
    public void testGetReferenceById() {
        Employees employee = ejr.getReferenceById(1);
        System.out.println(employee);
    }

    /**
     * 测试deleteAllByIdInBatch
     */
    @Test
    public void testDeleteAllByIdInBatch() {
        List<Integer> list = new ArrayList<>();
        list.add(16);
        ejr.deleteAllByIdInBatch(list);
    }
}
