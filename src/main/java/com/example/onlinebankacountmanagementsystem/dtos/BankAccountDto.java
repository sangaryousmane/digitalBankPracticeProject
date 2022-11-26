package com.example.onlinebankacountmanagementsystem.dtos;
import com.example.onlinebankacountmanagementsystem.entities.AccountOperation;
import com.example.onlinebankacountmanagementsystem.entities.Customer;
import com.example.onlinebankacountmanagementsystem.utilities.AccountStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data  @NoArgsConstructor
public class BankAccountDto {

    private Date created_at;
    private double balance;
    private AccountStatus accountStatus;
    private String currency;
    private Customer customer;
    private AccountOperation accountOperation;

}
