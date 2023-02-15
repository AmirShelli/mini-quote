package com.example.kameleoon.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @ManyToOne
    @JoinColumn(name="user_Id", nullable=false)
    @Getter @Setter
    private User user;

    @OneToMany(mappedBy = "quote")
    private List<Vote> votes;
    public void addVote(Vote vote) {
        votes.add(vote);
    }
    public Quote(String text, User user) {
        this.text = text;
        this.user = user;
    }
    public Quote() {

    }
    public Integer getNumberOfVotes() {
        return votes.stream().map(Vote::getValue)
                .reduce(0, Integer::sum);
    }
}
