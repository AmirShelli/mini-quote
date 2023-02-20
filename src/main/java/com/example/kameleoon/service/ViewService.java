package com.example.kameleoon.service;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.User;
import com.example.kameleoon.repository.QuoteRepository;
import com.example.kameleoon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ViewService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuoteRepository quoteRepository;
    public Quote getRandomQuote() throws Exception {
        List<Quote> quotes = quoteRepository.findAll();
        if (quotes.isEmpty()) {
            throw (new Exception(("There aren't any quotes here.")));
        }
        int randomIndex = new Random().nextInt(quotes.size());
        return quotes.get(randomIndex);
    }
    public List<Quote> getAllQuotesFromUser(Long userId) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with id: " + userId));
        return quoteRepository.findAllByUser(user).stream().toList();
    }
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }
    public List<Quote> getTopTenQuotes() {
        List<Quote> resultList = quoteRepository.getOrderedQuotesDesc();
        List<Quote> topTenQuotes = new ArrayList<>();
        for (int i = 0; i < Math.min(10, resultList.size()); i++)
            topTenQuotes.add(resultList.get(i));
        return topTenQuotes;
    }
    public List<Quote> getFlopTenQuotes() {
        List<Quote> resultList = quoteRepository.getOrderedQuotesAsc();
        List<Quote> topTenQuotes = new ArrayList<>();
        for (int i = 0; i < Math.min(10, resultList.size()); i++)
            topTenQuotes.add(resultList.get(i));
        return topTenQuotes;
    }

    public String listToString(List<Quote> quotes) {
        StringBuilder sb = new StringBuilder();
        for(Quote quote : quotes) {
            sb.append(quote.toString());
        }
        return sb.toString();
    }
}
