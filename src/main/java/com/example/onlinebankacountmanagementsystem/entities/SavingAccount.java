package com.example.onlinebankacountmanagementsystem.entities;

import com.example.onlinebankacountmanagementsystem.utilities.AccountStatus;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter @NoArgsConstructor
@DiscriminatorValue("Saving_Account")
public class SavingAccount extends BankAccount {
    private double interestRate;

    public SavingAccount(double interestRate, Date created_at,
                         double balance, AccountStatus accountStatus, String currency) {
        super(created_at, balance, accountStatus, currency);
        this.interestRate=interestRate;
    }

}
