package com.example.wallet.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import com.example.wallet.exceptions.TransactionAlreadyExistsException;
import com.example.wallet.models.RequestPayload;
import com.example.wallet.models.Transaction;
import com.example.wallet.repositories.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private TransactionRepository repository;
    @Autowired
    private PlayerService playerService;

    @Override
    public List<Transaction> findAll() {
        List<Transaction> transactions = (List<Transaction>) repository.findAll();
        return transactions;
    }

    public Transaction createTransaction(RequestPayload requestPayload) {
        Transaction tr = null;
        if (!repository.findById(requestPayload.getTransactionId()).isPresent()) {
            var player = playerService.getById(requestPayload.getPlayerId());
            tr = new Transaction(requestPayload.getTransactionId(), player, requestPayload.getAmount(), new Timestamp(Instant.now().getEpochSecond()*1000));
        } else {
            throw new TransactionAlreadyExistsException(requestPayload.getTransactionId());
        }
        return repository.save(tr);
    }

}
