package com.example.kameleoon.controller;

import com.example.kameleoon.configuration.Status;
import com.example.kameleoon.repository.UserRepository;
import com.example.kameleoon.model.User;
import com.example.kameleoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/user/register")
    public Status registerUser(@Validated @RequestBody User newUser) {
        List<User> users = findAllUsers();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            System.out.println("Registered user: " + newUser);
            if (user.equals(newUser)) {
                System.err.print("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userRepository.save(newUser);
        return Status.SUCCESS;
    }
    @PostMapping("/user/login")
    public Status loginUser(@Validated @RequestBody User user) {
        List<User> users = findAllUsers();
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(true);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    @PostMapping("/user/logout")
    public Status logUserOut(@Validated @RequestBody User user) {
        List<User> users = findAllUsers();
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}