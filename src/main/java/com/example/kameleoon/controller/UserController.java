package com.example.kameleoon.controller;

import com.example.kameleoon.dto.LoginDTO;
import com.example.kameleoon.dto.RegisterDTO;
import com.example.kameleoon.model.Status;
import com.example.kameleoon.model.User;
import com.example.kameleoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDTO registerDTO) {
        try {
            userService.createUser(registerDTO);
        }catch (Exception e) {
            return Status.FAILURE.toResponseEntity("Please provide correct data.");
        }
        return Status.SUCCESS.toResponseEntity("User successfully added.");
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO) {
        try {
            User user = userService.getUserByEmail(loginDTO.getEmail());
            if(loginDTO.getPassword().equals(user.getPassword()))
                return Status.SUCCESS.toResponseEntity("User successfully logged in.");
        } catch (Exception e) {
            return Status.FAILURE.toResponseEntity("User not found.");
        }
        return Status.FAILURE.toResponseEntity("Please provide correct password.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findUserById(@PathVariable long id) {
        try {
            User user = userService.getUserById(id);
            return Status.SUCCESS.toResponseEntity(user.toString());
        } catch (Exception e) {
            return Status.FAILURE.toResponseEntity("User not found.");
        }
    }

}