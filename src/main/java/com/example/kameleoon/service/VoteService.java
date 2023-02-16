package com.example.kameleoon.service;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.User;
import com.example.kameleoon.model.Vote;
import com.example.kameleoon.repository.QuoteRepository;
import com.example.kameleoon.repository.UserRepository;
import com.example.kameleoon.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VoteService {
    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VoteRepository voteRepository;
    @Transactional
    public void addVote(Long userId, Long quoteId, Vote vote) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()->new Exception("User not found by Id: " + userId));
        Quote quote = quoteRepository.findById(quoteId).orElseThrow(()->new Exception("User not found by Id: " + userId));
        if (quote.getVotes().stream().anyMatch(v -> v.getUser().getUserId().equals(userId))) {
            throw new Exception("User has already voted for this quote.");
        }
        user.addVote(vote);
        quote.addVote(vote);
        vote.setUser(user);
        vote.setQuote(quote);
        voteRepository.save(vote);
        userRepository.save(user);
        quoteRepository.save(quote);
    }
}
