package com.example.onlinebankacountmanagementsystem;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AccessMe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
