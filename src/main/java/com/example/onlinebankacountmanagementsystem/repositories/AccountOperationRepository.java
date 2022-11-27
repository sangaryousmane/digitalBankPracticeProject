package com.example.onlinebankacountmanagementsystem.repositories;

import com.example.onlinebankacountmanagementsystem.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {


    List<AccountOperation> getByAccounts_Id(String id);
}