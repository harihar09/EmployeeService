package com.EmployeeService.repository;

import com.EmployeeService.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    static Map<Long, Employee> empDetails = new HashMap<>();

    static {
        Employee e1 = new Employee(1L, "john", "john@gmail.com", "909808753", "us");
        Employee e2 = new Employee(2L, "clare", "clare@gmail.com", "909808753", "uk");
        Employee e3 = new Employee(3L, "doe", "doe@gmail.com", "909808753", "japan");
        Employee e4 = new Employee(4L, "keshav", "keshav@gmail.com", "8379096541", "india");
        Employee e5 = new Employee(5L, "ram", "ram@gmail.com", "874903762", "india");

        empDetails.put(1L, e1);
        empDetails.put(2L, e2);
        empDetails.put(3L, e3);
        empDetails.put(4L, e4);
        empDetails.put(5L, e5);
    }

    public Employee findById(Long id) {
        return empDetails.get(id);
    }

    public List<Employee> findAll(){
       // return new ArrayList<>(empDetails.values());
        return empDetails.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
