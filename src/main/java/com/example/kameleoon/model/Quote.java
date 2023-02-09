package com.example.kameleoon.model;

import jakarta.persistence.*;

@Entity
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quoteId;
    @Column(name = "TEXT", nullable = false)
    private String text;

    @Column(name = "AUTHOR",nullable = false)
    private String author;

    @Column(name = "VOTES",nullable = false)
    private Integer votes;

    public Quote(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public Quote() {

    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    public Long getQuoteId() {
        return quoteId;
    }
}
