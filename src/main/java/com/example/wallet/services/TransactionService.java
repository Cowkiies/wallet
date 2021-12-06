package com.example.wallet.services;

import java.util.List;

import com.example.wallet.models.Transaction;
import com.example.wallet.repositories.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private TransactionRepository repository;

    @Override
    public List<Transaction> findAll() {
        List<Transaction> transactions = (List<Transaction>) repository.findAll();
        return transactions;
    }
}
