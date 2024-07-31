package com.example.jpa_08_dynamic_query__query_by_example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import com.example.jpa_08_dynamic_query__query_by_example.domains.Employees;
import com.example.jpa_08_dynamic_query__query_by_example.repositories.QueryByExampleInterface;

@SpringBootTest
public class TestQueryByExample {

    @Autowired
    private QueryByExampleInterface repository;

    /**
     * 简单示例 按照firstName和lastName动态查询
     * 
     * Hibernate:
     * select
     * e1_0.emp_no,
     * e1_0.birth_date,
     * e1_0.first_name,
     * e1_0.gender,
     * e1_0.hire_date,
     * e1_0.last_name
     * from
     * employees e1_0
     * where
     * e1_0.last_name=?
     * and e1_0.first_name=?
     */
    @Test
    public void testQueryByExample() {

        Employees e = new Employees();
        e.setFirstName("sheldon");
        e.setLastName("cooper");

        Example<Employees> example = Example.of(e);

        Iterable<Employees> list = repository.findAll(example);

        list.forEach(item -> {
            System.out.println(item);
        });
    }

    /**
     * 通过匹配器进行条件限制
     * 此例中将忽略firstName属性限制的条件，最后查询语句为
     * ExampleMatcher的多个with方法可串联
     * select
     * e1_0.emp_no,
     * e1_0.birth_date,
     * e1_0.first_name,
     * e1_0.gender,
     * e1_0.hire_date,
     * e1_0.last_name
     * from
     * employees e1_0
     * where
     * e1_0.last_name=?
     */
    @Test
    public void testQueryByExampleIgnoreSpecificParam() {
        Employees e = new Employees();
        e.setFirstName("R");
        e.setLastName("white");

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("firstName");

        Example example = Example.of(e, matcher);

        Iterable<Employees> list = repository.findAll(example);

        list.forEach(item -> {
            System.out.println(item);
        });
    }

    /**
     * 忽略大小写
     * ExampleMatcher的多个with方法可串联
     * select
     * e1_0.emp_no,
     * e1_0.birth_date,
     * e1_0.first_name,
     * e1_0.gender,
     * e1_0.hire_date,
     * e1_0.last_name
     * from
     * employees e1_0
     * where
     * lower(e1_0.last_name)=?
     */
    @Test
    public void testQueryByExampleIgnoreCase() {
        Employees e = new Employees();
        e.setLastName("WHITE");

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase("lastName");
        Example example = Example.of(e, matcher);

        // Example example = Example.of(e);

        Iterable<Employees> list = repository.findAll(example);

        list.forEach(item -> {
            System.out.println(item);
        });
    }

    /**
     * 针对所有条件进行like条件匹配
     * 
     * select
     * e1_0.emp_no,
     * e1_0.birth_date,
     * e1_0.first_name,
     * e1_0.gender,
     * e1_0.hire_date,
     * e1_0.last_name
     * from
     * employees e1_0
     * where
     * e1_0.last_name like ? escape '\\'
     */
    @Test
    public void testQueryByExampleStringContain() {
        Employees e = new Employees();
        e.setLastName("wh");

        ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING);
        Example example = Example.of(e, matcher);

        // Example example = Example.of(e);

        Iterable<Employees> list = repository.findAll(example);

        list.forEach(item -> {
            System.out.println(item);
        });
    }
}
