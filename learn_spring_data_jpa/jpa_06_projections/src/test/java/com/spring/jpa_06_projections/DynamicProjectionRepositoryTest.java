package com.spring.jpa_06_projections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.jpa_06_projections.domain.Employees;
import com.spring.jpa_06_projections.dto.EmployeeName;
import com.spring.jpa_06_projections.jpainterfaces.DynamicProjectionRepository;

@SpringBootTest
public class DynamicProjectionRepositoryTest {

    @Autowired
    private DynamicProjectionRepository dpr;

    @Test
    public void testDynamicProjection() {

        // 返回完整的Employees类型
        Employees empItem = dpr.findByEmpNo(1, Employees.class);
        System.out.println(empItem);

        // 返回class based的子集类型
        EmployeeName empNameItem = dpr.findByEmpNo(2, EmployeeName.class);
        System.out.println(empNameItem);

        // 返回interface based的子集类型
        com.spring.jpa_06_projections.domaininterface.EmployeeName interfaceItem = dpr.findByEmpNo(3,
                com.spring.jpa_06_projections.domaininterface.EmployeeName.class);
        System.out.println(interfaceItem.getFullNameFromDefaultMethod());
    }
}
