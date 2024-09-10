package com.spring.jpa_06_projections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.jpa_06_projections.dto.EmployeeName;
import com.spring.jpa_06_projections.jpainterfaces.ClassBasedProjectionRepository;

@SpringBootTest
public class ClassBasedProjectionRepositoryTest {

    @Autowired
    private ClassBasedProjectionRepository cbpr;

    @Test
    public void testClassBasedProjection() {
        EmployeeName obj = cbpr.findByEmpNo(1);
        System.out.println(obj);
    }

}
