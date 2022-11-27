package com.example.onlinebankacountmanagementsystem.web;


import com.example.onlinebankacountmanagementsystem.dtos.CustomerDto;
import com.example.onlinebankacountmanagementsystem.service.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
@Slf4j
public class CustomerRestController {

    private final BankAccountService bankAccountService;

    @PostMapping("/saveCustomer")
    public CustomerDto saveCustomer(@RequestBody CustomerDto customerDto){
        return bankAccountService.saveCustomer(customerDto);
    }
}
