package com.example.kameleoon.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long usedId;
    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {

    }
//    private ArrayList<Quotes> LastVotes;

    public void setUsedId(Long usedId) {
        this.usedId = usedId;
    }


    public Long getUsedId() {
        return usedId;
    }
}
