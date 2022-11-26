package com.example.onlinebankacountmanagementsystem.entities;


import com.example.onlinebankacountmanagementsystem.AccessMe;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "Customer")
@Getter
@Setter
@NoArgsConstructor
public class Customer extends AccessMe {

    private String firstName;
    private String lastName;
    private String email;

    @OneToMany
    private List<BankAccount> accounts;

    public Customer(String firstName, String lastName,
                    String email, List<BankAccount> accounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.accounts = accounts;
    }

    private void linkedAccountWithCustomer(BankAccount account){
        if (!accounts.contains(account)){
            this.accounts.add(account);
        }
        this.accounts.remove(account);
    }
}
