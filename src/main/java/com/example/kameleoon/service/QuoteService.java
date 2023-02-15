package com.example.kameleoon.service;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.User;
import com.example.kameleoon.repository.QuoteRepository;
import com.example.kameleoon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        user.addQuote(quote);
        quoteRepository.save(quote);
        userRepository.save(user);
    }
    public void updateQuote(String updatedText, Long userId, Long quoteId) throws Exception {
        userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with id: " + userId));
        Quote quote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new Exception("Quote not found with id: " + quoteId));
        quote.setText(updatedText);
        quoteRepository.save(quote);
    }
    public void deleteQuote(Long quoteId, Long userId) throws Exception {
        userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with id: " + userId));
        quoteRepository.findById(quoteId)
                .orElseThrow(() -> new Exception("Quote not found with id: " + quoteId));
        quoteRepository.deleteById(quoteId);
    }
    public List<Quote> getAllQuotesFromUser(Long userId) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with id: " + userId));
        return quoteRepository.findAllByUser(user).stream().toList();
    }
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }
    public String listToString(List<Quote> quotes) {
        StringBuilder sb = new StringBuilder();
        for(Quote quote : quotes) {
            User user = quote.getUser();
            sb.append(quote.getText()).append(" | ")
                    .append(quote.getVotes()).append(" ")
                    .append(user.getName()).append("\n");
        }
        return sb.toString();
    }
}
