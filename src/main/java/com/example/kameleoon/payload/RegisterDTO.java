package com.example.kameleoon.payload;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class RegisterDTO {
    private Long user_Id;
    private String name;
    private String email;
    private String password;
    private Timestamp created_At;
}
