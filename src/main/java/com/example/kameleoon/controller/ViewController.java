package com.example.kameleoon.controller;

import com.example.kameleoon.service.QuoteService;
import com.example.kameleoon.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {
    @Autowired
    private QuoteService quoteService;
    @GetMapping("/topTenQuotes")
    public String viewTopTenQuotes() {
        return quoteService.listToString(quoteService.getTopTenQuotes());
    }

    @GetMapping("/flopTenQuotes")
    public String viewFlopTenQuotes() {
        return quoteService.listToString(quoteService.getFlopTenQuotes());
    }

}
