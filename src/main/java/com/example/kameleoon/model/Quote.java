package com.example.kameleoon.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
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
    @Column(name = "votes")
    @Getter
    private Integer numberOfVotes;
    @Column(name = "created_At")
    @Getter @Setter
    private Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name="user_Id", nullable=false)
    @Getter @Setter
    private User user;
    @OneToMany(mappedBy = "quote")
    @Getter
    private List<Vote> votes;
    public void addVote(Vote vote) {
        if (votes == null || numberOfVotes == null) {
            votes = new ArrayList<>();
            numberOfVotes = 0;
        }
        votes.add(vote);
        numberOfVotes += vote.getValue();
    }
    public Quote(String text, User user) {
        this.text = text;
        this.user = user;
        this.numberOfVotes = 0;
        this.votes = new ArrayList<>();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        User user = this.getUser();
        sb.append(this.getText()).append(" | ")
                .append(this.getNumberOfVotes()).append(" ")
                .append(createdAt.toString()).append(" ")
                .append(user.getName()).append("\n");
        return sb.toString();
    }
    public Quote() {

        this.numberOfVotes = 0;
        this.votes = new ArrayList<>();
    }
}
