package com.example.kameleoon.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public enum Status {
    SUCCESS(HttpStatus.OK),
    FAILURE(HttpStatus.BAD_REQUEST),
    USER_DOES_NOT_EXIST(HttpStatus.NOT_FOUND),
    USER_ALREADY_EXISTS(HttpStatus.IM_USED);

    private final HttpStatus httpStatus;

    Status(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ResponseEntity<String> toResponseEntity(String message) {
        return ResponseEntity.status(httpStatus).body(message);
    }

}