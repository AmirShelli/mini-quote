package com.example.kameleoon.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "VOTE")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vote_Id")
    private Long voteId;

    @ManyToOne
    @JoinColumn(name="user_Id", nullable=false)
    @Getter @Setter
    private User user;

    @ManyToOne
    @JoinColumn(name="quote_Id", nullable=false)
    @Getter @Setter
    private Quote quote;

    @Column(name = "val", nullable = false)
    @Getter @Setter
    private Integer value;

    public Vote(int value) {
        this.value = value;
    }

    public Vote() {
        value = 0;
    }
}
