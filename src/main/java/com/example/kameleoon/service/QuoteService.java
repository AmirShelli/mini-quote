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

    public Quote updateQuote(Long id, Quote updatedQuote) {
        Quote quote = quoteRepository.getOne(id);
        quote.setText(updatedQuote.getText());
        return quoteRepository.save(quote);
    }

    public Quote addQuote(String text, Long userId) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with id: " + userId));

        Quote quote = new Quote(text, user);
        return quoteRepository.save(quote);
    }
    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }
    public List<Quote> getAllQuotesFromUser(User user) {
        return quoteRepository.findAllByUser(user).stream().toList();
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
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }
}
