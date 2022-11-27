package com.example.onlinebankacountmanagementsystem.entities;

import com.example.onlinebankacountmanagementsystem.AccessMe;
import com.example.onlinebankacountmanagementsystem.utilities.OperationType;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountOperation extends AccessMe {


    private Date date;
    private double amount;

    @Enumerated(EnumType.STRING)
    private OperationType operation;

    @ManyToOne
    private BankAccount accounts;
    private String description;
}
