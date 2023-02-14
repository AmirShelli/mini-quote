package com.example.kameleoon.model;

import jakarta.persistence.*;

@Entity
@Table(name = "QUOTE")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "quote_Id")
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
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    public Long getQuoteId() {
        return quoteId;
    }
}
