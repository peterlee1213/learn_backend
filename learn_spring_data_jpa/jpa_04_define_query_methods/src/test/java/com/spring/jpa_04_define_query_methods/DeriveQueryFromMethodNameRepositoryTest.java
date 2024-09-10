package com.spring.jpa_04_define_query_methods;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.spring.jpa_04_define_query_methods.domain.Employees;
import com.spring.jpa_04_define_query_methods.repository.DeriveQueryFromMethodNameRepository;

@SpringBootTest
public class DeriveQueryFromMethodNameRepositoryTest {

    @Autowired
    private DeriveQueryFromMethodNameRepository dqfmnr;

    /**
     * 测试findByFirstNameOrLastName方法(默认就是忽略大小写的)
     */
    @Test
    public void testFindByFirstNameOrLastName() {
        List<Employees> list = dqfmnr.findByFirstNameOrLastName("peter", "Cooper");
        System.out.println(list);
    }

    /**
     * 测试findByLastNameOrderByEmpNoDesc方法
     */
    @Test
    public void testFindByLastNameOrderByEmpNoDesc() {
        // 这是等于不是like
        List<Employees> list = dqfmnr.findByLastNameOrderByEmpNoDesc("white");
        System.out.println(list);
    }

    /**
     * 测试findByLastName的分页方法
     * 注意这个pageNumber是从0开始的
     */
    @Test
    public void testFindByLastName() {
        List<Employees> list = dqfmnr.findAll(PageRequest.of(0, 2, Direction.DESC, "empNo"));
        System.out.println(list);
    }

}
