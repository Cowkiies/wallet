package com.example.wallet.services;

import java.util.List;

import com.example.wallet.enums.BetStatus;
import com.example.wallet.exceptions.BetNotFoundException;
import com.example.wallet.models.Bet;
import com.example.wallet.models.Player;
import com.example.wallet.models.RequestPayload;
import com.example.wallet.models.Wallet;
import com.example.wallet.repositories.BetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetService implements IBetService {
    @Autowired
    private BetRepository repository;
    @Autowired
    private WalletService walletService;
    @Autowired
    private TransactionService transactionService;

    @Override
    public List<Bet> findAll() {
        List<Bet> bets = (List<Bet>) repository.findAll();
        return bets;
    }

    @Override
    public Bet createBet(Player player, Integer cashAmount, Integer bonusAmount) {
        return repository.save(new Bet(player, cashAmount, bonusAmount, BetStatus.PENDING));
    }

    @Override
    public Wallet finalizeBet(RequestPayload requestPayload, Boolean hasWon) {
        return repository.findById(requestPayload.getBetId())
        .map(bet -> {
            var newStatus = hasWon ? BetStatus.WON : BetStatus.LOST;
            var amountWon = hasWon ? requestPayload.getAmount() : 0;
            var wallet = walletService.getById(bet.getPlayerId());
            var totalAmountBet = bet.getCashAmount() + bet.getBonusAmount();

            requestPayload.setPlayerId(bet.getPlayerId());
            transactionService.createTransaction(hasWon ? requestPayload : requestPayload.setNegativeAmount());
            System.out.println((bet.getCashAmount()/totalAmountBet) * amountWon);
            System.out.println((bet.getBonusAmount()/totalAmountBet) * amountWon);
            wallet.setCashAmount(wallet.getCashAmount() + (int)(((float)bet.getCashAmount()/totalAmountBet) * amountWon));
            wallet.setBonusAmount(wallet.getBonusAmount() + (int)(((float)bet.getBonusAmount()/totalAmountBet) * amountWon));
            bet.setStatus(newStatus);
            repository.save(bet);
            return walletService.saveWallet(wallet);
        }).orElseThrow(() -> new BetNotFoundException(requestPayload.getBetId()));
    }

}
