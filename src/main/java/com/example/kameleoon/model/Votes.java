package com.example.kameleoon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Votes {
    @Id
    Long vote_Id;
}
