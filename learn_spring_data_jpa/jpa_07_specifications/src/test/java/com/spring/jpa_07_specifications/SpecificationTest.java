package com.spring.jpa_07_specifications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import com.spring.jpa_07_specifications.domain.Employees;
import com.spring.jpa_07_specifications.enumclass.Gender;
import com.spring.jpa_07_specifications.repositories.EmployeesSpecificationsRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaBuilder.In;

@SpringBootTest
public class SpecificationTest {

    @Autowired
    private EmployeesSpecificationsRepository esr;

    /**
     * 查询empNo范围（in）
     * 通过birthDate进行大于>查询
     * 对lastName进行like查询
     */
    /**
     * 由此可见还是手写JPQL比较简单
     */
    @Test
    public void testSpecification() {
        List<Employees> all = esr.findAll(new Specification<Employees>() {

            @Override
            @Nullable
            public Predicate toPredicate(Root<Employees> root, @Nullable CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder) {

                /**
                 * root: 从实体类（Employees）中获取列
                 * criteriaBuilder：等同于where,用于设置各种条件（> < in like .....）
                 * query 组合（order by, where）
                 */

                Path<Integer> empNo = root.get("empNo");
                Path<Date> birthDate = root.get("birthDate");
                Path<String> firstName = root.get("firstName");
                Path<String> lastName = root.get("lastName");
                Path<Gender> gender = root.get("gender");
                Path<Date> hireDate = root.get("hireDate");

                /**
                 * expression就是字段名称，就是上面代码获取到的Path对象
                 */
                Predicate likeClause = criteriaBuilder.like(lastName, "%r%");

                In<Integer> inClause = criteriaBuilder.in(empNo);
                inClause.value(2).value(3).value(5);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date;
                try {
                    date = sdf.parse("1995-06-27");
                    Predicate greaterThanClause = criteriaBuilder.greaterThan(birthDate, date);
                    // 要返回多个where条件并且用and拼接的话用criteriaBuilder.and方法
                    return criteriaBuilder.and(likeClause, greaterThanClause, inClause);
                } catch (ParseException e) {
                    return null;
                }

            }

        });
        all.forEach(item -> {
            System.out.println(item);
        });
    }

}
