package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee add(@RequestBody Employee e){
        return service.addEmployee(e);
    }

    @GetMapping
    public List<Employee> show(){
        return service.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable int id){
        return service.getEmployee(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        service.deleteEmployee(id);
        return "Employee deleted";
    }
}