package com.example.onlinebankacountmanagementsystem;


import com.example.onlinebankacountmanagementsystem.entities.BankAccount;
import com.example.onlinebankacountmanagementsystem.entities.Customer;
import com.example.onlinebankacountmanagementsystem.repositories.CustomerRepository;
import org.glassfish.jaxb.core.v2.TODO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@Commit
public class AllRepositoryTests {

    private CustomerRepository customerRepository;


    @Test
    // TODO I will write some tests tomorrow, InSha Allah
    void saveCustomer(){

    }
}
