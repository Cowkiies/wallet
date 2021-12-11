package com.example.wallet.services;

import java.util.List;

import com.example.wallet.models.Bet;
import com.example.wallet.models.Player;

public interface IBetService {
    public List<Bet> findAll();
    public Bet createBet(Player player, Integer cashAmount, Integer bonusAmount);
}
