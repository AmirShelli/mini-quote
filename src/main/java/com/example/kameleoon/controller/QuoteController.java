package com.example.kameleoon.controller;

import com.example.kameleoon.dto.QuoteDTO;
import com.example.kameleoon.model.Status;
import com.example.kameleoon.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class QuoteController {
    @Autowired
    private QuoteService quoteService;

    @PostMapping("/{userId}/addQuote")
    public ResponseEntity<String> addQuote(@RequestBody QuoteDTO quoteDTO, @PathVariable @RequestAttribute("userId") Long userId) {
        try {
            quoteService.addQuote(quoteDTO.getText(), userId);
        } catch (Exception e) {
            return Status.FAILURE.toResponseEntity(e.getMessage());
        }
        return Status.SUCCESS.toResponseEntity("Quote successfully added.");
    }
    @PostMapping("/{userId}/{quoteId}/updateQuote")
    public ResponseEntity<String> updateQuote(@RequestBody QuoteDTO quoteDTO, @PathVariable @RequestAttribute("userId") Long userId,
                              @PathVariable @RequestAttribute("quoteId") Long quoteId){
        try {
            quoteService.updateQuote(quoteDTO.getText(), userId, quoteId);
        } catch (Exception e) {
            return Status.FAILURE.toResponseEntity(e.getMessage());
        }
        return Status.SUCCESS.toResponseEntity("Quote successfully updated.");
    }
    @PostMapping("/{userId}/{quoteId}/deleteQuote")
    public ResponseEntity<String> deleteQuoteFromUser(@PathVariable Long userId, @PathVariable @RequestAttribute("userId") Long quoteId)
    {
        try{
            quoteService.deleteQuote(quoteId, userId);
        }catch (Exception e) {
            return Status.FAILURE.toResponseEntity(e.getMessage());
        }
        return Status.SUCCESS.toResponseEntity("Quote successfully deleted.");
    }

}
