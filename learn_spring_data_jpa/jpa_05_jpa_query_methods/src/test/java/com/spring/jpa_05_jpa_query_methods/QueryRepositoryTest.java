package com.spring.jpa_05_jpa_query_methods;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.spring.jpa_05_jpa_query_methods.domain.Employees;
import com.spring.jpa_05_jpa_query_methods.repositories.QueryRepository;

@SpringBootTest
public class QueryRepositoryTest {

    @Autowired
    private QueryRepository qr;

    /**
     * 测试@Query注解的一般用法
     */
    @Test
    public void testQueryRepository() {
        Optional<Employees> employee = qr.findByEmpNo(1);
        System.out.println(employee);
    }

    /**
     * 测试在@Query注解中使用like查询子句
     * 百分号通配符可以加在?1这种变量的前面或后面
     */
    @Test
    public void testAdvancedLikeExpression() {
        List<Employees> employees = qr.advancedLikeExpression("r");
        System.out.println(employees);
    }

    /**
     * 测试在@Query中写原生SQL语句
     */
    @Test
    public void testNativeQuery() {
        List<Employees> employees = qr.nativeQuery("feller");
        System.out.println(employees);
    }

    /**
     * 测试自己写原生sql语句返回Page类型对象
     */
    @Test
    public void testReturnPage() {
        // 注意： 因为用的是原生sql,所以排序的字段必须写数据库中的字段而非对象名称
        // 如果是JPQL的话就得用对象的属性
        Page<Employees> pages = qr.returnPage(PageRequest.of(1, 2, Direction.DESC, "emp_no"));
        pages.forEach(item -> {
            System.out.println(item);
        });
        System.out.println(pages);
    }
}
