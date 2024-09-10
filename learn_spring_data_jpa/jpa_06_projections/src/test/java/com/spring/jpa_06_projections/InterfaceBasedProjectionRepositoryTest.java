package com.spring.jpa_06_projections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.jpa_06_projections.domaininterface.EmployeeName;
import com.spring.jpa_06_projections.jpainterfaces.InterfaceBasedProjectionRepository;

@SpringBootTest
public class InterfaceBasedProjectionRepositoryTest {

    @Autowired
    private InterfaceBasedProjectionRepository pr;

    /**
     * 通过创建一个interface类型来只查询和返回特定的字段而非全部字段, 测试1
     */
    @Test
    public void testProjectionWithInterfaceByName() {
        EmployeeName obj = pr.findByLastName("what");
        System.out.println(obj.getFirstName());
        System.out.println(obj.getLastName());
    }

    /**
     * 通过创建一个interface类型来只查询和返回特定的字段而非全部字段, 测试2
     */
    @Test
    public void testProjectionWithInterfaceByEmpNo() {
        EmployeeName obj = pr.findByEmpNo(1);
        System.out.println(obj.getFirstName());
        System.out.println(obj.getLastName());
    }

    /**
     * 手写的JPQL是否有用?
     * 必须得手动指定查询的字段，否则至少查询阶段还是查所有
     */
    @Test
    public void testProjectionWithInterfaceByEmpNoHandWriting() {
        EmployeeName obj = pr.findByEmpNoHandWrite(1);
        System.out.println(obj.getFirstName());
        System.out.println(obj.getLastName());
    }

    /**
     * 测试通过@Value进行opne projection, 并拼凑一个原实体类中没有的字段
     */
    @Test
    public void testValueOpenProjection() {
        EmployeeName obj = pr.findByEmpNo(1);
        System.out.println(obj.getFirstName());
        System.out.println(obj.getLastName());
        System.out.println(obj.getFullName());
    }

    /**
     * 通过在接口中定义default方法来进行简单的计算并拼凑出原实体类中没有的字段
     */
    @Test
    public void testDefaultMethodOpenProjection() {
        EmployeeName obj = pr.findByEmpNo(1);
        System.out.println(obj.getFirstName());
        System.out.println(obj.getLastName());
        System.out.println(obj.getFullNameFromDefaultMethod());
    }

    /**
     * 通过使用@myBean调用实体类中方法来拼接一个返回值
     * 这个myBean需要替换为目标实体类的bean名称
     * 实体类需要加@Component注解才能纳入spring容器，@Entity没这个功能
     */
    @Test
    public void testMyBeanOpenProjection() {
        EmployeeName obj = pr.findByEmpNo(1);
        System.out.println(obj.getFirstName());
        System.out.println(obj.getLastName());
        System.out.println(obj.getFullNameWithMyBean());
    }
}
