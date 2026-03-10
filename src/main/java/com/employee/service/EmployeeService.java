package com.employee.service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee addEmployee(Employee emp){
        return repository.save(emp);
    }

    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    public Employee getEmployee(int id){
        return repository.findById(id).orElse(null);
    }

    public void deleteEmployee(int id){
        repository.deleteById(id);
    }
}