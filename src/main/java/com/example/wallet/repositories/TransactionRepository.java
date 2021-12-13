package com.example.wallet.repositories;

import java.util.Date;
import java.util.List;

import com.example.wallet.models.Transaction;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository  extends JpaRepository<Transaction, Long>{
    public List<Transaction> findByDateUtcBetween(Date dateFrom, Date dateTo, Pageable pageable);
    public List<Transaction> findByDateUtcBetweenAndPlayerId(Date dateFrom, Date dateTo, Long playerId, Pageable pageable);
}
