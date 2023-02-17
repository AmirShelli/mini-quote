package com.example.kameleoon.service;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.User;
import com.example.kameleoon.repository.QuoteRepository;
import com.example.kameleoon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {
    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    private UserRepository userRepository;

    public void addQuote(String text, Long userId) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with id: " + userId));
        Quote quote = new Quote(text, user);
        quote.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
        quoteRepository.save(quote);
        user.addQuote(quote);
        userRepository.save(user);
    }
    public void updateQuote(String updatedText, Long userId, Long quoteId) throws Exception {
        userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with id: " + userId));
        Quote quote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new Exception("Quote not found with id: " + quoteId));
        quote.setText(updatedText);
        quote.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
        quoteRepository.save(quote);
    }
    public void deleteQuote(Long quoteId, Long userId) throws Exception {
        userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with id: " + userId));
        quoteRepository.findById(quoteId)
                .orElseThrow(() -> new Exception("Quote not found with id: " + quoteId));
        quoteRepository.deleteById(quoteId);
    }
}
