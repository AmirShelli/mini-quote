package com.example.kameleoon.service;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.User;
import com.example.kameleoon.repository.QuoteRepository;
import com.example.kameleoon.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

class QuoteServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private QuoteRepository quoteRepository;

    @InjectMocks
    private QuoteService quoteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddQuote() throws Exception {
        // Arrange
        Long userId = 1L;
        String text = "test quote";
        User user = new User();
        user.setId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Act
        quoteService.addQuote(text, userId);

        // Assert
        verify(userRepository, times(1)).save(user);
        verify(quoteRepository, times(1)).save(any(Quote.class));
    }
}
