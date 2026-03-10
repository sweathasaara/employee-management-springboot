package com.employee.entity;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double salary;
    private int departmentId;

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public double getSalary(){return salary;}
    public void setSalary(double salary){this.salary=salary;}

    public int getDepartmentId(){return departmentId;}
    public void setDepartmentId(int departmentId){this.departmentId=departmentId;}
}