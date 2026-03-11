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

    // ADD DEPARTMENT
    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        return service.addDepartment(department);
    }

    // GET ALL DEPARTMENTS
    @GetMapping
    public List<Department> getDepartments(){
        return service.getDepartments();
    }

    // DELETE DEPARTMENT
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable int id){
        service.deleteDepartment(id);
        return "Department deleted successfully";
    }
}