package com.example.onlinebankacountmanagementsystem.repositories;

import com.example.onlinebankacountmanagementsystem.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

    @Query("SELECT b FROM BankAccount b  WHERE b.currency=:currency")
    List<BankAccount> findByCurrencyEquals(@Param("currency") String currency);
}