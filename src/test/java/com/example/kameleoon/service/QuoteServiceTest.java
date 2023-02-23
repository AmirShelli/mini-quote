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

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void testUpdateQuote() throws Exception {
        // Arrange
        Long userId = 1L;
        Long quoteId = 2L;
        String updatedText = "updated quote";
        User user = new User();
        user.setId(userId);
        Quote quote = new Quote("old quote", user);
        quote.setId(quoteId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(quoteRepository.findById(quoteId)).thenReturn(Optional.of(quote));

        // Act
        quoteService.updateQuote(updatedText, userId, quoteId);

        // Assert
        assertEquals(updatedText, quote.getText());
        verify(quoteRepository, times(1)).save(quote);
    }

    @Test
    public void testDeleteQuote() throws Exception {
        // arrange
        Long userId = 1L;
        Long quoteId = 2L;
        User user = new User();
        user.setId(userId);
        Quote quote = new Quote("old quote", user);
        quote.setId(quoteId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(quoteRepository.findById(quoteId)).thenReturn(Optional.of(quote));

        // Act
        quoteService.deleteQuote(quoteId, userId);

        // Assert
        verify(quoteRepository, times(1)).deleteById(quoteId);
        verify(userRepository, times(1)).findById(userId);
        verify(quoteRepository, times(1)).findById(quoteId);
    }

}
