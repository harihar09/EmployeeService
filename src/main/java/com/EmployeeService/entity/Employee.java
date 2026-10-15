package com.EmployeeService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String emailId;
    private String phoneNumber;
    private String country;
}
