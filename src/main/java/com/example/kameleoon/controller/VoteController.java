package com.example.kameleoon.controller;

import com.example.kameleoon.model.Status;
import com.example.kameleoon.model.Vote;
import com.example.kameleoon.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class VoteController {
    @Autowired
    private VoteService voteService;
    @PostMapping("/{userId}/{quoteId}/upVote")
    public Status upVote(@PathVariable @RequestAttribute Long userId, @PathVariable @RequestAttribute Long quoteId) {
        try {
            voteService.addVote(userId, quoteId, new Vote(1));
        } catch (Exception e) {
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }
    @PostMapping("/{userId}/{quoteId}/downVote")
    public Status downVote(@PathVariable @RequestAttribute Long userId, @PathVariable @RequestAttribute Long quoteId) {
        try {
            voteService.addVote(userId, quoteId, new Vote(-1));
        } catch (Exception e) {
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }
}
