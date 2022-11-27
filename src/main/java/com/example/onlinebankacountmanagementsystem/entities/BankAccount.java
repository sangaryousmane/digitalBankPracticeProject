package com.example.onlinebankacountmanagementsystem.entities;

import com.example.onlinebankacountmanagementsystem.AccessMe;
import com.example.onlinebankacountmanagementsystem.utilities.AccountStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity(name = "BankAccount")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4)
@Getter
@Setter
@NoArgsConstructor
public abstract class BankAccount {


    @Id
    private String id;
    private Date created_at;
    private double balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private String currency;

    @ManyToOne(
            targetEntity = Customer.class,
            optional = false)
    private Customer customer;

    @OneToMany(mappedBy = "accounts")
    private List<AccountOperation> accountOperation;


    public BankAccount(Date created_at, double balance,
                       AccountStatus accountStatus, String currency) {
        this.created_at = created_at;
        this.balance = balance;
        this.accountStatus = accountStatus;
        this.currency = currency;
    }


}
