package com.employee.repository;

import com.employee.entity.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.LoginDetails;

public interface LoginRepository extends JpaRepository<LoginDetails, Long> {

    Optional<LoginDetails> findByUsername(String username);
}