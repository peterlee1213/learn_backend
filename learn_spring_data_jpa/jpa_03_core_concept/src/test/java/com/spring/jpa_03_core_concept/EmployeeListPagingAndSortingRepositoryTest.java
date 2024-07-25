package com.spring.jpa_03_core_concept;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.spring.jpa_03_core_concept.domain.Employees;
import com.spring.jpa_03_core_concept.jpainterfaces.EmployeeListPagingAndSortingRepository;

@SpringBootTest
public class EmployeeListPagingAndSortingRepositoryTest {

    @Autowired
    private EmployeeListPagingAndSortingRepository elpasr;

    /**
     * 测试分页的findAll的附带Pageable的方法(不带Sort)
     * Page对象有很多的方法可调用
     */
    @Test
    public void testFindAllWithPageable() {
        Page<Employees> employeeList = elpasr.findAll(PageRequest.of(2, 2));
        employeeList.forEach(item -> {
            System.out.println(item);
        });
        System.out.println(employeeList.getSize());
        System.out.println(employeeList.hasPrevious());
        System.out.println(employeeList.nextPageable());
    }

    /**
     * 测试分页的findAll方法（附带page和sort）
     */
    @Test
    public void testFindAllWithPageableAndSort() {
        Page<Employees> list = elpasr.findAll(PageRequest.of(2, 2, Direction.DESC, "empNo"));
        list.forEach(item -> {
            System.out.println(item);
        });
    }
}
