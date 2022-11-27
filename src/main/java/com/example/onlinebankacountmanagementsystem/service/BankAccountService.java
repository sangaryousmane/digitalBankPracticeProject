package com.example.onlinebankacountmanagementsystem.service;
import com.example.onlinebankacountmanagementsystem.dtos.*;
import com.example.onlinebankacountmanagementsystem.exceptions.BankAccountNotFoundException;
import com.example.onlinebankacountmanagementsystem.exceptions.CustomerNotFoundException;
import com.example.onlinebankacountmanagementsystem.exceptions.InsufficientBalanceException;

import java.util.List;

public interface BankAccountService {

    CustomerDto saveCustomer(CustomerDto customerDto);

    CurrentAccountDto saveCurrentAccount(double currentBalance, double overdraft, Long id) throws CustomerNotFoundException;

    SavingAccountDto saveSavingAccount(double currentBalance, double interestRate, Long id) throws CustomerNotFoundException;

    List<CustomerDto> customerList();

    BankAccountDto getBankAccount(String accountId) throws BankAccountNotFoundException;

    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, InsufficientBalanceException;

    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;

    void transfer(String accountIdSource, String accountIdDestination, double amount);

    List<BankAccountDto> listBankAccounts();

    CustomerDto getCustomer(Long id) throws CustomerNotFoundException;

    CustomerDto updateCustomer(CustomerDto customerDto);

    void deleteCustomer(Long customerId);

    List<AccountOperationDto> accountOperationHistory(String accountId);

}
