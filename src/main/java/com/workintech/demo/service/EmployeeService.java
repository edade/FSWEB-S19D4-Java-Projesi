package com.workintech.demo.service;



import com.workintech.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    Employee delete(Long id);

    Employee findByEmail(String email);

    List<Employee> findBySalary(double salary);

    List<Employee> findByOrder();
}