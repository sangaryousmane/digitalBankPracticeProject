package com.example.onlinebankacountmanagementsystem.entities;

import com.example.onlinebankacountmanagementsystem.utilities.AccountStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor
public class CurrentAccount extends BankAccount{

    private double overdraft;

    public CurrentAccount(Date created_at, double balance,
                          AccountStatus accountStatus, String currency, double overdraft) {
        super(created_at, balance, accountStatus, currency);
        this.overdraft = overdraft;
    }
}
