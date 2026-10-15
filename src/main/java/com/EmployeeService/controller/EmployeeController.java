package com.EmployeeService.controller;

import com.EmployeeService.DTO.EmployeeDTO;
import com.EmployeeService.exception.EmployeeNotFoundException;
import com.EmployeeService.service.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    // this method returns employee details based on id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmpDetailsById(@PathVariable Long id) throws EmployeeNotFoundException {

        EmployeeDTO employeeDTO = employeeService.findById(id);
        if (employeeDTO == null) {
            // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            //  return ResponseEntity.notFound().build();
            return ResponseEntity.status(404).build();


        }
        return ResponseEntity.ok(employeeDTO);
        //return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);
    }

    // this method returns all the employees details

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmpDetails() {
        List<EmployeeDTO> empList = employeeService.findAll();
        if (empList == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(empList);
    }
}
