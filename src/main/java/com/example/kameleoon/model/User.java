package com.example.kameleoon.model;

import jakarta.persistence.*;

@Entity
@Table (name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;
//    private ArrayList<Quotes> LastVotes;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(Long usedId) {
        this.userId = usedId;
    }


    public Long getUserId() {
        return userId;
    }
}
