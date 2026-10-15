package com.EmployeeService.service;

import com.EmployeeService.DTO.EmployeeDTO;
import com.EmployeeService.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO findById(Long id) throws EmployeeNotFoundException;

    List<EmployeeDTO> findAll();
}
