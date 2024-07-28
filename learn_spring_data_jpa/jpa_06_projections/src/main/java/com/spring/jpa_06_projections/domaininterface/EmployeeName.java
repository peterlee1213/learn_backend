package com.spring.jpa_06_projections.domaininterface;

import org.springframework.beans.factory.annotation.Value;

//作为Employees entity查询的返回值类型，仅查询firstName和lastName字段
public interface EmployeeName {

    public String getFirstName();

    public String getLastName();

    // 查询结果映射到此接口时，进行简单计算后直接拼接出来，就用不着再跑循环遍历了
    // target表示当前对象
    @Value("#{target.firstName + ' ' + target.lastName}")
    public String getFullName();

    // 通过调用实体类中的getFullName方法来作为此方法返回值
    // @后面跟的是实体类对应bean的名称
    // 实体类需要加@Component注解才能纳入spring容器，@Entity没这个功能
    @Value("#{@employees.getFullName(target)}")
    public String getFullNameWithMyBean();

    default String getFullNameFromDefaultMethod() {
        return this.getFirstName() + ' ' + this.getLastName();
    }

}
