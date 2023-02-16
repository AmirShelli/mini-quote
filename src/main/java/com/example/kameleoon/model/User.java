package com.example.kameleoon.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "USERS")
@ToString
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "user_Id")
    @Getter
    private Long userId;
    @Column(nullable = false)
    @Getter @Setter
    private String name;
    @Column(nullable = false)
    @Getter @Setter
    private String password;
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String email;
    @CreationTimestamp
    @Column(name = "created_At", updatable = false)
    @Getter @Setter
    private Date createdAt;
    @Column(name = "logged_In")
    @Getter @Setter
    private Boolean loggedIn;

    @OneToMany(mappedBy = "user")
    @Getter
    private List<Quote> quotes;

    @OneToMany(mappedBy = "user")
    @Getter
    private List<Vote> votes;


    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.votes = new ArrayList<>();
        this.quotes = new ArrayList<>();
    }

    public User() {
        this.votes = new ArrayList<>();
        this.quotes = new ArrayList<>();
    }
    public void addQuote(Quote quote) {
        quotes.add(quote);
    }
    public void addVote(Vote vote) {
        if (votes == null)
            votes = new ArrayList<>();
        votes.add(vote);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email) || userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, password, email, createdAt);
    }
}
