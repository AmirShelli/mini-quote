package com.example.kameleoon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {


    @GetMapping("/topQuotes")
    public String viewTopTenQuotes() {

        return "Welcome to my application";
    }

    @GetMapping("/flopQuotes")
    public String viewFlopTenQuotes() {

        return "This is an example endpoint";
    }

}
