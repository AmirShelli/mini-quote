package com.example.kameleoon.controller;

import com.example.kameleoon.dto.QuoteDTO;
import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.Status;
import com.example.kameleoon.model.User;
import com.example.kameleoon.service.QuoteService;
import com.example.kameleoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class QuoteController {
    @Autowired
    private QuoteService quoteService;
    @Autowired
    private UserService userService;

    @PostMapping("/quote/{userId}/addQuote")
    public Status addQuote(@RequestBody QuoteDTO quoteDTO, @PathVariable @RequestAttribute("userId") Long userId) {
        try {
            quoteService.addQuote(quoteDTO.getText(), userId);
        } catch (Exception e) {
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }
    @PostMapping("/quote/{userId}/getAllQuotes")
    public String getAllQuotesFromUser(@PathVariable @RequestAttribute("userId") Long userId) {
        try {
            User user = userService.getUserById(userId);
            List<Quote> quotes = quoteService.getAllQuotesFromUser(user);
            return quoteService.listToString(quotes);
        } catch (Exception e) {
            return Status.USER_DOES_NOT_EXIST.toString();
        }
    }
    @GetMapping("/quote/getAllQuotes")
    public String getAllQuotes() {
        try {
            return quoteService.listToString(quoteService.getAllQuotes());
        } catch (Exception e) {
            return Status.USER_DOES_NOT_EXIST.toString();
        }
    }

}
