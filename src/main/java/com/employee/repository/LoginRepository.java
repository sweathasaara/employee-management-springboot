package com.employee.repository;

import com.employee.entity.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginDetails,Integer> {

    Optional<LoginDetails> findByUsername(String username);
}