package com.example.wallet.repositories;

import com.example.wallet.enums.BetStatus;
import com.example.wallet.models.Bet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Long>{
    public Page<Bet> findByPlayerId(Long id, Pageable pageable);
    public Page<Bet> findByStatus(BetStatus status, Pageable pageable);
    public Page<Bet> findByPlayerIdAndStatus(Long id, BetStatus status, Pageable pageable);
}
