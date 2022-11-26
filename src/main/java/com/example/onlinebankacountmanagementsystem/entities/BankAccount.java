package com.example.onlinebankacountmanagementsystem.entities;

import com.example.onlinebankacountmanagementsystem.AccessMe;
import com.example.onlinebankacountmanagementsystem.utilities.AccountStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity(name = "BankAccount")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
public class BankAccount extends AccessMe {

    private Date created_at;
    private double balance;
    private AccountStatus accountStatus;
    private String currency;

    @ManyToOne(
            targetEntity = Customer.class,
            optional = false)
    private Customer customer;

    @ManyToOne
    private AccountOperation accountOperation;


    public BankAccount(Date created_at, double balance,
                       AccountStatus accountStatus, String currency) {
        this.created_at = created_at;
        this.balance = balance;
        this.accountStatus = accountStatus;
        this.currency = currency;
    }



}
