package com.example.kameleoon.controller;

import com.example.kameleoon.model.Status;
import com.example.kameleoon.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ViewController {
    @Autowired
    private ViewService viewService;
    @GetMapping("/")
    public ResponseEntity<String> defaultView() {
        return Status.SUCCESS.toResponseEntity("Welcome to the main page.");
    }
    @GetMapping("/topTenQuotes")
    public ResponseEntity<String> viewTopTenQuotes() {
        return Status.SUCCESS.toResponseEntity(viewService.listToString(viewService.getTopTenQuotes()));
    }

    @GetMapping("/flopTenQuotes")
    public ResponseEntity<String> viewFlopTenQuotes() {
        return Status.SUCCESS.toResponseEntity(viewService.listToString(viewService.getFlopTenQuotes()));
    }
    @PostMapping("/{userId}/getAllQuotes") // corrupted(
    public ResponseEntity<String> getAllQuotesFromUser(@PathVariable @RequestAttribute("userId") Long userId) {
        try {
            return Status.SUCCESS.toResponseEntity(viewService.listToString(viewService.getAllQuotesFromUser(userId)));
        } catch (Exception e) {
            return Status.FAILURE.toResponseEntity(e.getMessage());
        }
    }
    @GetMapping("/getAllQuotes")
    public ResponseEntity<String> getAllQuotes() {
        return Status.SUCCESS.toResponseEntity(viewService.listToString(viewService.getAllQuotes()));
    }
    @GetMapping("/getRandomQuote")
    public ResponseEntity<String> getRandomQuote() {
        try {
            return Status.SUCCESS.toResponseEntity(viewService.getRandomQuote().toString());
        } catch (Exception e) {
            return Status.SUCCESS.toResponseEntity(e.getMessage());
        }
    }
}
