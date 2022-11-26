package com.example.onlinebankacountmanagementsystem.entities;

import com.example.onlinebankacountmanagementsystem.AccessMe;
import com.example.onlinebankacountmanagementsystem.utilities.OperationType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class AccountOperation extends AccessMe {

    private Date date;
    private double amount;
    private OperationType operation;

    @OneToMany
    private List<BankAccount> accounts;
}
