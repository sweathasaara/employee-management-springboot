package com.employee.entity;

import jakarta.persistence.*;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int employeeId;
    private String date;
    private String status;

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public int getEmployeeId(){return employeeId;}
    public void setEmployeeId(int employeeId){this.employeeId=employeeId;}

    public String getDate(){return date;}
    public void setDate(String date){this.date=date;}

    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}
}