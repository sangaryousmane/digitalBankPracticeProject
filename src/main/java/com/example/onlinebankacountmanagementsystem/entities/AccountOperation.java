package com.example.onlinebankacountmanagementsystem.entities;

import com.example.onlinebankacountmanagementsystem.AccessMe;
import com.example.onlinebankacountmanagementsystem.utilities.OperationType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor
public class Operation extends AccessMe {

    private Date date;
    private double amount;
    private OperationType operation;
}
