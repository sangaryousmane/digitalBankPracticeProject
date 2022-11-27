package com.example.onlinebankacountmanagementsystem.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("Current_Account")
public class CurrentAccount extends BankAccount {

    private double overdraft;
}
