package com.ujjawal.bugtrackingsystem.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujjawal.bugtrackingsystem.dto.UserRequestDto;
import com.ujjawal.bugtrackingsystem.dto.UserResponseDto;
import com.ujjawal.bugtrackingsystem.entity.User;
import com.ujjawal.bugtrackingsystem.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody UserRequestDto requestDto){

        UserResponseDto savedUser = userService.registerUser(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping
    public ResponseEntity<List <User>> getAllUsers(){
        List<User> user = userService.getAllUsers();

        return ResponseEntity.ok(user);
    }
}
