package com.example.wallet.repositories;

import com.example.wallet.models.Transaction;
import org.springframework.data.repository.CrudRepository;
public interface TransactionRepository  extends CrudRepository<Transaction, Long>{
    
}
