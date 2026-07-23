package com.aditya.aiinterviewplatform.service;

import org.springframework.stereotype.Service;

import com.aditya.aiinterviewplatform.dto.SignupRequest;

@Service
public class UserService {

    public String registerUser(SignupRequest request) {
        return "User " + request.getName() + " registered successfully!";
    }
}
