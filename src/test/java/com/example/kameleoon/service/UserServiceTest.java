package com.example.kameleoon.service;

import com.example.kameleoon.dto.RegisterDTO;
import com.example.kameleoon.model.User;
import com.example.kameleoon.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser() throws Exception {
        // Arrange
        RegisterDTO registerDTO = new RegisterDTO("test", "test@test.com", "password");
        User newUser = new User(registerDTO.getName(), registerDTO.getEmail(), registerDTO.getPassword());
        when(userRepository.existsByEmail(registerDTO.getEmail())).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(newUser);

        // Act
        User createdUser = userService.createUser(registerDTO);

        // Assert
        assertNotNull(createdUser);
        assertEquals(newUser.getName(), createdUser.getName());
        assertEquals(newUser.getEmail(), createdUser.getEmail());
        assertEquals(newUser.getPassword(), createdUser.getPassword());

        verify(userRepository, times(1)).existsByEmail(registerDTO.getEmail());
        verify(userRepository, times(1)).save(newUser);
    }

    @Test
    void createUserThrowsException() {
        // Arrange
        RegisterDTO registerDTO = new RegisterDTO("test", "test@test.com", "password");
        when(userRepository.existsByEmail(registerDTO.getEmail())).thenReturn(true);

        // Act & Assert
        assertThrows(Exception.class, () -> userService.createUser(registerDTO));

        verify(userRepository, times(1)).existsByEmail(registerDTO.getEmail());
        verify(userRepository, never()).save(any(User.class));
    }
}
