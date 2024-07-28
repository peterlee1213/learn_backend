package com.spring.jpa_05_jpa_query_methods;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jpa_05_jpa_query_methods.domain.Employees;
import com.spring.jpa_05_jpa_query_methods.repositories.QueryRepository;

@SpringBootTest
public class QueryRepositoryTest {

    @Autowired
    private ApplicationContext applicationContext;

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

    /**
     * 测试手写JPQL中添加sort
     */
    @Test
    public void testFindAllAndSort() {
        List<Employees> list = qr.findAllAndSort(Sort.by("empNo").descending());
        System.out.println(list);
    }

    /**
     * 测试Named Parameters,使用具体名称而非?1来代替变量
     */
    @Test
    public void testNamedParameters() {
        List<Employees> list = qr.findByLastNameTestNamedParameter("r");
        System.out.println(list);
    }

    /**
     * 测试#{#entityName}
     */
    @Test
    public void testEntityName() {
        List<Employees> list = qr.findAllTestEntityName();
        System.out.println(list);
    }

    /**
     * 测试没有escape方法的时候传进的字符串含有%或者_
     * 结果百分号被解析为数据库通配符了
     */
    @Test
    public void testGetStringWithoutEscape() {
        List<Employees> list = qr.findByLastNameTestWithoutEscape("%r%");
        System.out.println(list);
    }

    /**
     * 测试有escape方法的时候传进的字符串含有%或者_
     * 这些字符不会被解析为通配符
     */
    @Test
    public void testGetStringWithEscape() {
        List<Employees> list = qr.findByLastNameTestWithEscape("%r%");
        System.out.println(list);
    }

    /**
     * 测试更新语句
     */
    @Test
    @Transactional
    public void testUpdateFirstNameById() {
        // this is the first method
        // try {
        // int result = qr.updateFirstNameById("Mogan", 1);
        // qr.flush();
        // System.out.println(result);
        // System.out.println(qr.findById(1));
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        // this is the second method
        QueryRepository bean = applicationContext.getBean(QueryRepository.class);
        int result = bean.updateFirstNameById("Mogan", 1);
        System.out.println(result);
        System.out.println(qr.findById(1));
    }

    /**
     * 测试queryHints
     */
    // @Test
    // public void testQueryHints() {
    // Page<Employees> list = qr.findByLastName("wolowitz", PageRequest.of(0, 2));
    // list.forEach(item -> {
    // System.out.println(item);
    // });
    // }
}
