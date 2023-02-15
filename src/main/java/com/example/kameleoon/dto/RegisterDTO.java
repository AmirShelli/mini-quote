package com.example.kameleoon.dto;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RegisterDTO {
    private String name;
    private String email;
    private String password;

}
