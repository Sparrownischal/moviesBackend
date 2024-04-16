package com.example.movieapp_backend.controllers;

public class EmailAlreadyExistsExcept extends RuntimeException{

    public EmailAlreadyExistsExcept(String email) {
        super("This email " + email + " already exists.");
    }

}

