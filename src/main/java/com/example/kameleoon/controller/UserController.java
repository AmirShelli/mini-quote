package com.example.kameleoon.controller;

import com.example.kameleoon.model.Status;
import com.example.kameleoon.repository.UserRepository;
import com.example.kameleoon.model.User;
import com.example.kameleoon.dto.*;
import com.example.kameleoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @PostMapping("/user/register")
    public Status registerUser(@Validated @RequestBody RegisterDTO registerDTO) {
        if(registerDTO.getName() == null || registerDTO.getEmail() == null || registerDTO.getPassword() == null)
            return Status.FAILURE;
        System.out.println("Registered user: " + registerDTO);
        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            return Status.USER_ALREADY_EXISTS;
        }

        User user = new User();
        user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        userRepository.save(user);
        return Status.SUCCESS;
    }
    @PostMapping("/user/login")
    public Status loginUser(@Validated @RequestBody LoginDTO loginDTO) {
        try {
            User user = userService.getUserByEmail(loginDTO.getEmail());
            if(loginDTO.getPassword().equals(user.getPassword()))
                return Status.SUCCESS;
        } catch (Exception e) {
            return Status.USER_DOES_NOT_EXIST;
        }
        return Status.FAILURE;
    }

    @GetMapping("/{id}")
    public String findUserById(@PathVariable(value = "id") long id) {
        Optional<User> user = userRepository.findById(id);
        return user.toString();
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}