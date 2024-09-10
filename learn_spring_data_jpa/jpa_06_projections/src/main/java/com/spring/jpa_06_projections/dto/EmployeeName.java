package com.spring.jpa_06_projections.dto;

import org.springframework.stereotype.Component;

@Component("employeeNameClass")
public record EmployeeName(String firstName, String lastName) {

}
