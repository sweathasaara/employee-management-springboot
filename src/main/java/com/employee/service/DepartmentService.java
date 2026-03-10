package com.employee.service;

import com.employee.entity.Department;
import com.employee.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department addDepartment(Department d){
        return repository.save(d);
    }

    public List<Department> getDepartments(){
        return repository.findAll();
    }

    public void deleteDepartment(int id){
        repository.deleteById(id);
    }
}