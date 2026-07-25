package com.aditya.aiinterviewplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.aiinterviewplatform.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}