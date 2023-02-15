package com.example.kameleoon.service;

import com.example.kameleoon.dto.RegisterDTO;
import com.example.kameleoon.model.User;
import com.example.kameleoon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUserByEmail(String email) throws Exception
    {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new Exception("User not found with email: "+ email));
    }
    public User getUserById(Long id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new Exception("User not found with ID: "+ id));
    }
    public void createUser(RegisterDTO newUser) throws Exception{
        if (!userRepository.existsByEmail(newUser.getEmail())) {
            User user = new User();
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            userRepository.save(user);
        }
        throw (new Exception(("User with this email already Exists!")));
    }

}
