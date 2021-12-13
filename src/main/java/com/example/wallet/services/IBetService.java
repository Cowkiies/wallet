package com.example.wallet.services;

import java.util.List;

import com.example.wallet.models.Bet;
import com.example.wallet.models.Player;
import com.example.wallet.models.RequestPayload;
import com.example.wallet.models.Wallet;

public interface IBetService {
    public List<Bet> findAll();
    public Bet createBet(Player player, float cashAmount, float bonusAmount);
    public Wallet finalizeBet(RequestPayload requestPayload, Boolean hasWon);
}
