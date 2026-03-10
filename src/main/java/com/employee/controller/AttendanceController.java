package com.employee.controller;

import com.employee.entity.Attendance;
import com.employee.service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping("/present")
    public Attendance present(@RequestBody Attendance a){
        a.setStatus("Present");
        return service.markAttendance(a);
    }

    @PostMapping("/absent")
    public Attendance absent(@RequestBody Attendance a){
        a.setStatus("Absent");
        return service.markAttendance(a);
    }
}