package com.example.wallet.services;

import java.util.List;

import com.example.wallet.enums.BetStatus;
import com.example.wallet.models.Bet;
import com.example.wallet.models.Player;
import com.example.wallet.repositories.BetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetService implements IBetService {
    @Autowired
    private BetRepository repository;

    @Override
    public List<Bet> findAll() {
        List<Bet> bets = (List<Bet>) repository.findAll();
        return bets;
    }

    @Override
    public Bet createBet(Player player, Integer cashAmount, Integer bonusAmount) {
        return repository.save(new Bet(player, cashAmount, bonusAmount, BetStatus.PENDING));
    }
}
