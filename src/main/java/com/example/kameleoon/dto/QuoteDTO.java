package com.example.kameleoon.dto;

import com.example.kameleoon.model.User;
import lombok.Data;

@Data
public class QuoteDTO {
    private String text;
    private Integer votes;
    private User user;
}
