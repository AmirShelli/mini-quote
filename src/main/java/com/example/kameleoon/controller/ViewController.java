package com.example.kameleoon.controller;

import com.example.kameleoon.model.Status;
import com.example.kameleoon.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {
    @Autowired
    private QuoteService quoteService;
    @GetMapping("/topTenQuotes")
    public ResponseEntity<String> viewTopTenQuotes() {
        return Status.SUCCESS.toResponseEntity(quoteService.listToString(quoteService.getTopTenQuotes()));
    }

    @GetMapping("/flopTenQuotes")
    public ResponseEntity<String> viewFlopTenQuotes() {
        return Status.SUCCESS.toResponseEntity(quoteService.listToString(quoteService.getFlopTenQuotes()));
    }

}
