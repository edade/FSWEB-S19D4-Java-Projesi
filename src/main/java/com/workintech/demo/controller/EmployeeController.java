package com.workintech.demo.controller;


import com.workintech.demo.entity.Employee;
import com.workintech.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/order")
    public List<Employee> findByOrder(){
        return employeeService.findByOrder();
    }
}