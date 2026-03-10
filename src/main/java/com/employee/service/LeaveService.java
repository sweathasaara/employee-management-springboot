package com.employee.service;

import com.employee.entity.Leave;
import com.employee.repository.LeaveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository repository;

    public Leave applyLeave(Leave leave){
        leave.setStatus("Pending");
        return repository.save(leave);
    }

    public void approveLeave(int id){
        Leave leave = repository.findById(id).orElse(null);
        if(leave!=null){
            leave.setStatus("Approved");
            repository.save(leave);
        }
    }

    public void rejectLeave(int id){
        Leave leave = repository.findById(id).orElse(null);
        if(leave!=null){
            leave.setStatus("Rejected");
            repository.save(leave);
        }
    }
}