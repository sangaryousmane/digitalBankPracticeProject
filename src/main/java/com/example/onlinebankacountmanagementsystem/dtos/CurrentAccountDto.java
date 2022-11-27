package com.example.onlinebankacountmanagementsystem.dtos;

import com.example.onlinebankacountmanagementsystem.utilities.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
public class CurrentAccountDto extends BankAccountDto {

    private String id;
    private Date created_at;
    private double balance;
    private CustomerDto customerDto;
    private AccountStatus accountStatus;
    private double overdraft;


    public CurrentAccountDto() {
    }
}
