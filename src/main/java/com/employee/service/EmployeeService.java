package com.employee.service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    private Map<Integer, String> loginSessions = new HashMap<>();

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    public Employee getEmployee(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }

    public Set<String> getUniqueEmployeeNames() {

        List<Employee> employees = repository.findAll();

        Set<String> names = new HashSet<>();

        for(Employee emp : employees){
            names.add(emp.getName());
        }

        return names;
    }

    public Map<Integer, String> getDepartmentMap(){

        Map<Integer,String> deptMap = new HashMap<>();

        deptMap.put(101,"HR");
        deptMap.put(102,"IT");
        deptMap.put(103,"Finance");
        deptMap.put(108,"Testing");
        deptMap.put(110,"Admin");

        return deptMap;
    }

    public List<Employee> getHighSalaryEmployees(double salary){

        List<Employee> employees = repository.findAll();
        List<Employee> result = new ArrayList<>();

        for(Employee emp : employees){
            if(emp.getSalary() > salary){
                result.add(emp);
            }
        }

        return result;
    }
    public List<Employee> sortEmployeesBySalary(){

        List<Employee> employees = repository.findAll();

        employees.sort(Comparator.comparingDouble(Employee::getSalary));

        return employees;
    }
    public String loginEmployee(int employeeId){

        Optional<Employee> emp = repository.findById(employeeId);

        if(emp.isPresent()){

            String sessionId = UUID.randomUUID().toString();

            loginSessions.put(employeeId, sessionId);

            return "Login successful. Session ID: " + sessionId;
        }

        return "Employee not found";
    }

    public Map<Integer,String> getLoginSessions(){
        return loginSessions;
    }

}