package com.example.onlinebankacountmanagementsystem.repositories;

import com.example.onlinebankacountmanagementsystem.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountOperationRepository extends JpaRepository<AccountOperation, Integer> {
}