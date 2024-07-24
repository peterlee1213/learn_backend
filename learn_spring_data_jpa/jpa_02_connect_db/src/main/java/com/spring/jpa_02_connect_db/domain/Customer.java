package com.spring.jpa_02_connect_db.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // 声明为JPA实体类
@Table(name = "tb_customer") // 映射到哪个表
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    @Id // 这个属性是主键
    @Column(name = "cust_id") // 这个字段对应的数据库列信息
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增方式
    private Long custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_address")
    private String custAddress;
}
