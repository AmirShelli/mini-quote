package com.example.kameleoon.service;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.repository.QuoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ViewServiceTest {
    @Mock
    private QuoteRepository quoteRepository;

    @InjectMocks
    private ViewService viewService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTopTenQuotes() {
        // Arrange
        List<Quote> quotes = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Quote quote = new Quote();
            quote.setId((long) i);
            quote.setText("Quote " + i);
            quote.setNumberOfVotes(i);
            quotes.add(quote);
        }
        when(quoteRepository.getOrderedQuotesDesc()).thenReturn(quotes);

        // Act
        List<Quote> topQuotes = viewService.getTopOrFlopTenQuotes(true);

        // Assert
        assertEquals(10, topQuotes.size());
        assertEquals("Quote 14", topQuotes.get(0).getText());
        assertEquals("Quote 13", topQuotes.get(1).getText());
        assertEquals("Quote 12", topQuotes.get(2).getText());
        assertEquals("Quote 11", topQuotes.get(3).getText());
        assertEquals("Quote 10", topQuotes.get(4).getText());
        assertEquals("Quote 9", topQuotes.get(5).getText());
        assertEquals("Quote 8", topQuotes.get(6).getText());
        assertEquals("Quote 7", topQuotes.get(7).getText());
        assertEquals("Quote 6", topQuotes.get(8).getText());
        assertEquals("Quote 5", topQuotes.get(9).getText());
    }

    @Test
    public void testGetFlopTenQuotes() {
        // Arrange
        List<Quote> quotes = new ArrayList<>();
        for (int i = 15; i > 0; i--) {
            Quote quote = new Quote();
            quote.setId((long) i);
            quote.setText("Quote " + i);
            quote.setNumberOfVotes(i);
            quotes.add(quote);
        }
        when(quoteRepository.getOrderedQuotesAsc()).thenReturn(quotes);

        // Act
        List<Quote> flopQuotes = viewService.getTopOrFlopTenQuotes(false);

        // Assert
        assertEquals(10, flopQuotes.size());
        assertEquals("Quote 0", flopQuotes.get(0).getText());
        assertEquals("Quote 1", flopQuotes.get(1).getText());
        assertEquals("Quote 2", flopQuotes.get(2).getText());
        assertEquals("Quote 3", flopQuotes.get(3).getText());
        assertEquals("Quote 4", flopQuotes.get(4).getText());
        assertEquals("Quote 5", flopQuotes.get(5).getText());
        assertEquals("Quote 6", flopQuotes.get(6).getText());
        assertEquals("Quote 7", flopQuotes.get(7).getText());
        assertEquals("Quote 8", flopQuotes.get(8).getText());
        assertEquals("Quote 9", flopQuotes.get(9).getText());
    }
}
