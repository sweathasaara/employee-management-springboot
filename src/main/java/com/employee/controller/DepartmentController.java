package com.employee.controller;

import com.employee.entity.Department;
import com.employee.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping
    public Department add(@RequestBody Department d){
        return service.addDepartment(d);
    }

    @GetMapping
    public List<Department> show(){
        return service.getDepartments();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        service.deleteDepartment(id);
        return "Department deleted";
    }
}