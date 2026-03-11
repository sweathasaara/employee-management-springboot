package com.employee.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "login_details")
public class LoginDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_id")
    private int employeeId;

    private String username;

    @Column(name = "password_hash")
    private String password;

    public int getId() { return id; }

    public int getEmployeeId() { return employeeId; }

    public String getUsername() { return username; }

    public String getPassword() { return password; }
}