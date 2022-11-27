package com.example.onlinebankacountmanagementsystem.dtos;

import com.example.onlinebankacountmanagementsystem.utilities.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class SavingAccountDto extends BankAccountDto {

    private double interestRate;
    private String id;
    private Date created_at;
    private double balance;
    private CustomerDto customerDto;
    private AccountStatus accountStatus;

    public SavingAccountDto() {
    }
}
