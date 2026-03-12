package com.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.LoginDetails;
import com.employee.repository.LoginRepository;

@Service
public class AuthService {

    @Autowired
    private LoginRepository loginRepository;

    public String login(String username, String password) {

        Optional<LoginDetails> user = loginRepository.findByUsername(username);

        if (user.isEmpty()) {
            return "User not found";
        }

        if (!user.get().getPasswordHash().equals(password)) {
            return "Invalid password";
        }

        return "Login Successful";
    }
}