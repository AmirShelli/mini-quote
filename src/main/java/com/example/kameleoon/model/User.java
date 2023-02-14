package com.example.kameleoon.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

@Entity
@Table (name = "USERS")
@ToString
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
    private Timestamp createdAt;
    @Column(name = "logged_In")
    @Getter @Setter
    private Boolean loggedIn;

    @OneToMany(mappedBy = "user")
    private List<Quote> quotes;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {

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
