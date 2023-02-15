package com.example.kameleoon.controller;

import com.example.kameleoon.dto.QuoteDTO;
import com.example.kameleoon.model.Status;
import com.example.kameleoon.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class QuoteController {
    @Autowired
    private QuoteService quoteService;

    @PostMapping("/{userId}/addQuote")
    public Status addQuote( @RequestBody QuoteDTO quoteDTO, @PathVariable @RequestAttribute("userId") Long userId) {
        try {
            quoteService.addQuote(quoteDTO.getText(), userId);
        } catch (Exception e) {
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }
    @PostMapping("/{userId}/updateQuote/{quoteId}")
    public Status updateQuote(@RequestBody QuoteDTO quoteDTO, @PathVariable @RequestAttribute("userId") Long userId,
                              @PathVariable @RequestAttribute("quoteId") Long quoteId){
        try {
            quoteService.updateQuote(quoteDTO.getText(), userId, quoteId);
        } catch (Exception e) {
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }
    @PostMapping("/{userId}/getAllQuotes")
    public String getAllQuotesFromUser(@PathVariable @RequestAttribute("userId") Long userId) {
        try {
            return quoteService.listToString(quoteService.getAllQuotesFromUser(userId));
        } catch (Exception e) {
            return Status.USER_DOES_NOT_EXIST.toString();
        }
    }
    @GetMapping("/quote/getAllQuotes")
    public String getAllQuotes() {
        return quoteService.listToString(quoteService.getAllQuotes());
    }

    @PostMapping("/{userId}/deleteQuote/{quoteId}")
    public Status deleteQuoteFromUser(@PathVariable Long userId, @PathVariable @RequestAttribute("userId") Long quoteId)
    {
        try{
            quoteService.deleteQuote(quoteId, userId);
        }catch (Exception e) {
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }

}
