package com.employee.controller;

import com.employee.entity.Leave;
import com.employee.service.LeaveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService service;

    @PostMapping("/apply")
    public Leave apply(@RequestBody Leave l) {
        return service.applyLeave(l);
    }

    @PutMapping("/{id}/approve")
    public String approve(@PathVariable int id) {
        service.approveLeave(id);
        return "Leave approved";
    }

    @PutMapping("/{id}/reject")
    public String reject(@PathVariable int id) {
        service.rejectLeave(id);
        return "Leave rejected";
    }
}