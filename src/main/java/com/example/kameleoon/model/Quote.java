package com.example.kameleoon.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "QUOTE")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "quote_Id")
    @Getter @Setter
    private Long quoteId;
    @Column(nullable = false)
    @Getter @Setter
    private String text;
    @Column(nullable = false)
    @Getter @Setter
    private Integer votes;
    @ManyToOne
    @JoinColumn(name="user_Id", nullable=false)
    @Getter @Setter
    private User user;
    public Quote(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public Quote() {

    }
}
