package com.employee.service;

import com.employee.entity.Attendance;
import com.employee.repository.AttendanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repository;

    public Attendance markAttendance(Attendance attendance){
        return repository.save(attendance);
    }
}