package com.ujjawal.bugtrackingsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ujjawal.bugtrackingsystem.entity.User;
import com.ujjawal.bugtrackingsystem.repository.UserRepository;
import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {

            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);

    }

    public List <User> getAllUsers() {  
        return userRepository.findAll();       // we used object we created in same class
    }
}
