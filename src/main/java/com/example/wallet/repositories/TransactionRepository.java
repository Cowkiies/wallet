package com.example.wallet.repositories;

import com.example.wallet.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository  extends JpaRepository<Transaction, Integer>{
    
}
