package com.example.kameleoon.service;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.User;
import com.example.kameleoon.model.Vote;
import com.example.kameleoon.repository.QuoteRepository;
import com.example.kameleoon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {
    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    private UserRepository userRepository;

    public void addVote(Long userId, Long quoteId, Vote vote) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()->new Exception("User not found by Id: " + userId));
        Quote quote = quoteRepository.findById(quoteId).orElseThrow(()->new Exception("User not found by Id: " + userId));
        // can check if user's votes are contained in this quote
        user.addVote(vote);
        quote.addVote(vote);
        userRepository.save(user);
        quoteRepository.save(quote);
    }
}
