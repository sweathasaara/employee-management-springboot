package com.employee.entity;

import jakarta.persistence.*;


import jakarta.persistence.*;

@Entity
@Table(name = "employee_leave")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int employeeId;
    private String reason;
    private String status;

    // getters and setters

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public int getEmployeeId(){return employeeId;}
    public void setEmployeeId(int employeeId){this.employeeId=employeeId;}

    public String getReason(){return reason;}
    public void setReason(String reason){this.reason=reason;}

    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}
}