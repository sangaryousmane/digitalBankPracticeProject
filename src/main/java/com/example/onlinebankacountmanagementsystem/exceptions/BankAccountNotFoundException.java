package com.example.onlinebankacountmanagementsystem.exceptions;

public class BankAccountNotFoundException extends RuntimeException{

    public BankAccountNotFoundException(String message) {
        super(message);
    }
}
