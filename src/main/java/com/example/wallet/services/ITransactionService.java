package com.example.wallet.services;

import java.util.List;

import com.example.wallet.models.Transaction;

public interface ITransactionService {
    public List<Transaction> findAll();
}
