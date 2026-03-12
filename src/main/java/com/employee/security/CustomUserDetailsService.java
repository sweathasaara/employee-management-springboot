package com.employee.security;

import com.employee.entity.LoginDetails;
import com.employee.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        LoginDetails user = repository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Invalid username"));

        return User.withUsername(user.getUsername())
                .password("{noop}" + user.getPasswordHash())
                .roles("EMPLOYEE")
                .build();
    }
}