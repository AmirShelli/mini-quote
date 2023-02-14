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
    private UserService userService;
    @PostMapping("/user/register")
    public Status registerUser(@Valid @RequestBody RegisterDTO registerDTO) {
        try {
            userService.createUser(registerDTO);
        } catch (Exception e) {
            return Status.FAILURE;
        }
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
    public String findUserById(@PathVariable long id) {
        try {
            User user = userService.getUserById(id);
            return user.toString();
        } catch (Exception e) {
            return Status.USER_DOES_NOT_EXIST.toString();
        }
    }

}