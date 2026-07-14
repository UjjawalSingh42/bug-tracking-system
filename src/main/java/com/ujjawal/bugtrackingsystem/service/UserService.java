package com.ujjawal.bugtrackingsystem.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ujjawal.bugtrackingsystem.dto.UserRequestDto;
import com.ujjawal.bugtrackingsystem.dto.UserResponseDto;
import com.ujjawal.bugtrackingsystem.entity.User;
import com.ujjawal.bugtrackingsystem.exception.EmailAlreadyExistsException;
import com.ujjawal.bugtrackingsystem.repository.UserRepository;
import java.util.List;
import com.ujjawal.bugtrackingsystem.entity.Role;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                        PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDto registerUser(UserRequestDto requestDto) {
        User existingUser = userRepository.findByEmail(requestDto.getEmail());

        if (existingUser != null) {

            throw new EmailAlreadyExistsException("Email already exists");
        }
        // return null;

        User user = new User();

        user.setName(requestDto.getName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setRole(Role.USER);

        User savedUser = userRepository.save(user);

        UserResponseDto responseDto = new UserResponseDto();

        responseDto.setId(savedUser.getId());
        responseDto.setName(savedUser.getName());
        responseDto.setEmail(savedUser.getEmail());
        responseDto.setRole(savedUser.getRole());
        return responseDto;

    }

    public List<User> getAllUsers() {
        return userRepository.findAll(); // we used object we created in same class
    }
}
