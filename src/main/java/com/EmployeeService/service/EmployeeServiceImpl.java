package com.EmployeeService.service;

import com.EmployeeService.DTO.EmployeeDTO;
import com.EmployeeService.entity.Employee;
import com.EmployeeService.exception.EmployeeNotFoundException;
import com.EmployeeService.repository.EmployeeRepository;
import com.EmployeeService.transformer.EmpTransformer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO findById(Long id) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(id);
        if(employee == null){
            // throw custom exception
            throw new EmployeeNotFoundException("Employee with id "+id+" is not found");
        }
        return EmpTransformer.toDTO(employee);
    }

    @Override
    public List<EmployeeDTO> findAll() {
       /* List<Employee> employees =  employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for(Employee employee : employees){
            EmployeeDTO dto = EmpTransformer.toDTO(employee);
            employeeDTOS.add(dto);
        }
        return employeeDTOS;*/
        return employeeRepository.findAll().stream()
                .map(EmpTransformer::toDTO)
                .collect(Collectors.toList());
    }
}
