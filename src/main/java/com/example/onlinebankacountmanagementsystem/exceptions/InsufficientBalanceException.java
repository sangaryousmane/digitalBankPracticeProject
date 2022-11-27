package com.example.onlinebankacountmanagementsystem.exceptions;


public class InsufficientBalanceException extends RuntimeException{

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
