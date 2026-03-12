package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return service.getEmployee(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Employee emp = service.getEmployee(id);

        if(emp == null){
            throw new RuntimeException("Employee not found");
        }

        service.deleteEmployee(id);

        return "Employee deleted successfully";
    }

    @GetMapping("/unique-names")
    public Set<String> uniqueNames(){
        return service.getUniqueEmployeeNames();
    }

    @GetMapping("/departments")
    public Map<Integer,String> departments(){
        return service.getDepartmentMap();
    }

    @GetMapping("/salary/{amount}")
    public List<Employee> highSalary(@PathVariable double amount){
        return service.getHighSalaryEmployees(amount);
    }

    @GetMapping("/sorted")
    public List<Employee> sortedEmployees(){
        return service.sortEmployeesBySalary();
    }

    @PostMapping("/login/{id}")
    public String login(@PathVariable int id){
        return service.loginEmployee(id);
    }

    @GetMapping("/sessions")
    public Map<Integer,String> sessions(){
        return service.getLoginSessions();
    }

}