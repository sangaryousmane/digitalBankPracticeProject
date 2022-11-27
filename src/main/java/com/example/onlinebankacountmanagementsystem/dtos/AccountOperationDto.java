package com.example.onlinebankacountmanagementsystem.dtos;

import com.example.onlinebankacountmanagementsystem.entities.BankAccount;
import com.example.onlinebankacountmanagementsystem.utilities.OperationType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class AccountOperationDto {

    private Long id;
    private Date date;
    private double amount;
    private OperationType operation;
    private String description;




}
