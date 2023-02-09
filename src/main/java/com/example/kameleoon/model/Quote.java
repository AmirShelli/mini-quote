package com.example.kameleoon.model;

import jakarta.persistence.*;

@Entity
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quoteId;
    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
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
