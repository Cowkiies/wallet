package com.example.wallet.services;

import java.util.List;

import com.example.wallet.enums.BetStatus;
import com.example.wallet.models.Bet;
import com.example.wallet.models.Player;
import com.example.wallet.models.RequestPayload;
import com.example.wallet.models.Wallet;

import org.springframework.data.domain.Pageable;

public interface IBetService {
    public List<Bet> findAll();
    public Bet findById(Long id);
    public List<Bet> findByPlayerId(Long id, Pageable pageable);
    public List<Bet> findByStatus(BetStatus status, Pageable pageable);
    public List<Bet> findByPlayerIdAndStatus(Long id, BetStatus status, Pageable pageable);
    public Bet createBet(Player player, float cashAmount, float bonusAmount);
    public Wallet finalizeBet(RequestPayload requestPayload, Boolean hasWon);
}
