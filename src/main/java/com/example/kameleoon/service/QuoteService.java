package com.example.kameleoon.service;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {
    @Autowired
    private QuoteRepository quoteRepository;

    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    public Quote updateQuote(Long id, Quote updatedQuote) {
        Quote quote = quoteRepository.getOne(id);
        quote.setText(updatedQuote.getText());
        quote.setUser(updatedQuote.getUser());
        return quoteRepository.save(quote);
    }

    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }
}
