package com.example.onlinebankacountmanagementsystem.repositories;

import com.example.onlinebankacountmanagementsystem.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}