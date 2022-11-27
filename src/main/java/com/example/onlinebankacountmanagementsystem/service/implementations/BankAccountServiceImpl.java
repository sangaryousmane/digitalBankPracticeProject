package com.example.onlinebankacountmanagementsystem.service.implementations;
import com.example.onlinebankacountmanagementsystem.dtos.*;
import com.example.onlinebankacountmanagementsystem.entities.*;
import com.example.onlinebankacountmanagementsystem.exceptions.BankAccountNotFoundException;
import com.example.onlinebankacountmanagementsystem.exceptions.CustomerNotFoundException;
import com.example.onlinebankacountmanagementsystem.exceptions.InsufficientBalanceException;
import com.example.onlinebankacountmanagementsystem.mappers.BankAccountMapperImpl;
import com.example.onlinebankacountmanagementsystem.repositories.AccountOperationRepository;
import com.example.onlinebankacountmanagementsystem.repositories.BankAccountRepository;
import com.example.onlinebankacountmanagementsystem.repositories.CustomerRepository;
import com.example.onlinebankacountmanagementsystem.service.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.onlinebankacountmanagementsystem.utilities.OperationType.CREDIT;
import static com.example.onlinebankacountmanagementsystem.utilities.OperationType.DEBIT;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final AccountOperationRepository accountOperationRepository;
    public final BankAccountRepository bankAccountRepository;
    private final BankAccountMapperImpl accountMapper;
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = accountMapper.fromCustomerDto(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        log.info("Customer saved successfully...");
        return accountMapper.fromCustomer(savedCustomer);
    }

    @Override
    public CurrentAccountDto saveCurrentAccount(double currentBalance, double overdraft, Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found...");
        }

        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.setId(UUID.randomUUID().toString());
        currentAccount.setCreated_at(new Date());
        currentAccount.setBalance(currentBalance);
        currentAccount.setOverdraft(overdraft);
        currentAccount.setCustomer(customer);
        CurrentAccount savedBanAccount = bankAccountRepository.save(currentAccount);
        return accountMapper.fromCurrentAccount(savedBanAccount);
    }

    @Override
    public SavingAccountDto saveSavingAccount(double currentBalance, double interestRate, Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found..");
        }
        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setId(UUID.randomUUID().toString());
        savingAccount.setCreated_at(new Date());
        savingAccount.setBalance(currentBalance);
        savingAccount.setInterestRate(interestRate);
        savingAccount.setCustomer(customer);
        SavingAccount savedAccount = bankAccountRepository.save(savingAccount);
        log.info("Fund save successful");
        return accountMapper.fromSavingAccount(savedAccount);
    }

    @Override
    public List<CustomerDto> customerList() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(accountMapper::fromCustomer).toList();
    }

    @Override
    public BankAccountDto getBankAccount(String accountId) throws BankAccountNotFoundException {
        BankAccount bankAccount = bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new BankAccountNotFoundException("Sorry!! Bank Account not found..."));
        if (bankAccount instanceof SavingAccount savingAccount) {
            return accountMapper.fromSavingAccount(savingAccount);
        } else {
            CurrentAccount currentAccount = (CurrentAccount) bankAccount;
            return accountMapper.fromCurrentAccount(currentAccount);
        }
    }

    @Override
    public void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, InsufficientBalanceException {
        BankAccount bankAccount = bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new BankAccountNotFoundException("Bank account not found...."));
        if (bankAccount.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient Balance...");
        }
        AccountOperation operation = new AccountOperation();
        operation.setOperation(DEBIT);
        operation.setAmount(amount);
        operation.setDescription(description);
        operation.setAccounts(bankAccount);
        accountOperationRepository.save(operation);
        bankAccount.setBalance(bankAccount.getBalance() - amount);
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public void credit(String accountId, double amount, String description) throws BankAccountNotFoundException {
        BankAccount bankAccount = bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new BankAccountNotFoundException("Bank account not found.."));
        AccountOperation operation = new AccountOperation();
        operation.setOperation(CREDIT);
        operation.setAmount(amount);
        operation.setDescription(description);
        operation.setDate(new Date());
        operation.setAccounts(bankAccount);
        accountOperationRepository.save(operation);
        bankAccount.setBalance(bankAccount.getBalance() + amount);
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public void transfer(String accountIdSource, String accountIdDestination, double amount) {
        debit(accountIdSource, amount, "Transfer to " + accountIdDestination);
        credit(accountIdDestination, amount, "Transfer from " + accountIdSource);
        log.info("Transfer successful");
    }

    @Override
    public List<BankAccountDto> listBankAccounts() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        return bankAccounts.stream()
                .map(bankAccount -> {
                    if (bankAccount instanceof SavingAccount savingAccount) {
                        return accountMapper.fromSavingAccount(savingAccount);
                    } else {
                        CurrentAccount currentAccount = (CurrentAccount) bankAccount;
                        return accountMapper.fromCurrentAccount(currentAccount);
                    }
                }).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomer(Long id) throws CustomerNotFoundException {
        Customer customer=customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found..."));
        return accountMapper.fromCustomer(customer);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        Customer customer=accountMapper.fromCustomerDto(customerDto);
        Customer savedCustomer=customerRepository.save(customer);
        return accountMapper.fromCustomer(savedCustomer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        boolean exist=customerRepository.existsById(customerId);
        if (exist) {
            customerRepository.deleteById(customerId);
        }
        throw new CustomerNotFoundException("Customer with Id "+customerId+" not found...");
    }

    @Override
    public List<AccountOperationDto> accountOperationHistory(String accountId) {
       List<AccountOperation> accountOperationHistory=accountOperationRepository.getByAccounts_Id(accountId);
       return accountOperationHistory.stream().map(accountMapper::fromAccountOperation).toList();
    }
}
