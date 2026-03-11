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

    // ADD EMPLOYEE
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    // GET ALL EMPLOYEES
    @GetMapping
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    // GET EMPLOYEE BY ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return service.getEmployee(id);
    }

    // DELETE EMPLOYEE
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Employee emp = service.getEmployee(id);

        if(emp == null) {
            throw new RuntimeException("Employee not found");
        }

        service.deleteEmployee(id);

        return "Employee deleted successfully";
    }
}