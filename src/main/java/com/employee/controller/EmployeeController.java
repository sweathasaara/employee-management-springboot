package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")

@Tag(name = "Employee API", description = "Employee Management System APIs")

public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // ADD EMPLOYEE
    @Operation(summary = "Add a new employee")
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    // GET ALL EMPLOYEES
    @Operation(summary = "Retrieve all employees")
    @GetMapping
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    // GET EMPLOYEE BY ID
    @Operation(summary = "Get employee details by ID")
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return service.getEmployee(id);
    }

    // DELETE EMPLOYEE
    @Operation(summary = "Delete employee by ID")
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Employee emp = service.getEmployee(id);

        if(emp == null){
            throw new RuntimeException("Employee not found");
        }

        service.deleteEmployee(id);

        return "Employee deleted successfully";
    }
}