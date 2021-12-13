package com.example.wallet.services;

import java.util.List;

import com.example.wallet.models.RequestPayload;
import com.example.wallet.models.Transaction;

import org.springframework.data.domain.Pageable;

public interface ITransactionService {
    public List<Transaction> findAll();
    public Transaction findById(Long id);
    public List<Transaction> getAllBetweenDates(String dateFrom, String dateTo, Pageable pageable);
    public List<Transaction> findByDateUtcBetweenAndPlayerId(String dateTo, String dateFrom, Long playerId, Pageable pageable);
    public Transaction createTransaction(RequestPayload requestPayload);
}
