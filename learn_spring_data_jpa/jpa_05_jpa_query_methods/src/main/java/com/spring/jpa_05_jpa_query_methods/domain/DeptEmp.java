package com.spring.jpa_05_jpa_query_methods.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "dept_emp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeptEmp {
    private Employees employee;
    private Departments department;
}
