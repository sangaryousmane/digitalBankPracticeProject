package com.example.onlinebankacountmanagementsystem.mappers;

import com.example.onlinebankacountmanagementsystem.dtos.AccountOperationDto;
import com.example.onlinebankacountmanagementsystem.dtos.CurrentAccountDto;
import com.example.onlinebankacountmanagementsystem.dtos.CustomerDto;
import com.example.onlinebankacountmanagementsystem.dtos.SavingAccountDto;
import com.example.onlinebankacountmanagementsystem.entities.AccountOperation;
import com.example.onlinebankacountmanagementsystem.entities.CurrentAccount;
import com.example.onlinebankacountmanagementsystem.entities.Customer;
import com.example.onlinebankacountmanagementsystem.entities.SavingAccount;
import com.example.onlinebankacountmanagementsystem.utilities.AccountStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl {

    // Copying from customer to customerDto
    public CustomerDto fromCustomer(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    // Copying from customerDto to customer, the reverse of the above
    public Customer fromCustomerDto(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }

    // Copying from savingAccount to savingAccountDto
    public SavingAccountDto fromSavingAccount(SavingAccount savingAccount) {
        SavingAccountDto savingAccountDto = new SavingAccountDto();
        BeanUtils.copyProperties(savingAccount, savingAccountDto);
        savingAccountDto.setCustomerDto(fromCustomer(savingAccount.getCustomer()));
        savingAccountDto.setType(savingAccount.getClass().getSimpleName());
        return savingAccountDto;
    }

    // From savingAccountDto back to SavingAccount
    public SavingAccount fromSavingAccountDto(SavingAccountDto savingAccountDto){
        SavingAccount savingAccount=new SavingAccount();
        BeanUtils.copyProperties(savingAccountDto, savingAccount);
        savingAccount.setCustomer(fromCustomerDto(savingAccountDto.getCustomerDto()));
        return savingAccount;
    }

    // Copying from CurrentAccount to CurrentAccountDto
    public CurrentAccountDto fromCurrentAccount(CurrentAccount currentAccount){
        CurrentAccountDto currentAccountDto=new CurrentAccountDto();
        BeanUtils.copyProperties(currentAccount, currentAccountDto);
        currentAccountDto.setCustomerDto(fromCustomer(currentAccount.getCustomer()));
        currentAccountDto.setType(currentAccount.getClass().getSimpleName());
        return currentAccountDto;
    }

    // Copying properties from CurrentAccountDto to currentAccount
    public CurrentAccount fromCurrentAccountDto(CurrentAccountDto currentAccountDto){
        CurrentAccount currentAccount=new CurrentAccount();
        BeanUtils.copyProperties(currentAccountDto, currentAccount);
        currentAccount.setCustomer(fromCustomerDto(currentAccountDto.getCustomerDto()));
        return currentAccount;
    }

    // Copying properties from AccountOperation to AccountOperationDto
    public AccountOperationDto fromAccountOperation(AccountOperation accountOperation){
        AccountOperationDto accountOperationDto=new AccountOperationDto();
        BeanUtils.copyProperties(accountOperation, accountOperationDto);
        return accountOperationDto;
    }

}
