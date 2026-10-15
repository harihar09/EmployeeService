package com.EmployeeService.transformer;

import com.EmployeeService.DTO.EmployeeDTO;

public class EmpTransformer {

    public static EmployeeDTO toDTO(com.EmployeeService.entity.Employee employee) {

        if(employee == null)
            return null;

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setEmailId(employee.getEmailId());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setCountry(employee.getCountry());
        return employeeDTO;

    }
}
