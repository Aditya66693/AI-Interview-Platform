package com.aditya.aiinterviewplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aditya.aiinterviewplatform.dto.LoginRequest;
import com.aditya.aiinterviewplatform.dto.SignupRequest;
import com.aditya.aiinterviewplatform.entity.User;
import com.aditya.aiinterviewplatform.repository.UserRepository;

@Service
public class UserService {

    @Autowired
private UserRepository userRepository;

@Autowired
private PasswordEncoder passwordEncoder;

    public String registerUser(SignupRequest request) {

    User existingUser = userRepository.findByEmail(request.getEmail());

    if (existingUser != null) {
        return "Email already registered!";
    }

    User user = new User();

    user.setName(request.getName());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));

    userRepository.save(user);

    return "User registered successfully!";
}

    public String loginUser(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            return "User not found!";
        }

      if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
    return "Login Successful!";
}   else {
    return "Invalid Password!";
}
    }
}