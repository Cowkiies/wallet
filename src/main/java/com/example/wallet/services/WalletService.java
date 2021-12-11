package com.example.wallet.services;

import java.util.List;

import com.example.wallet.exceptions.NotEnoughFundsException;
import com.example.wallet.exceptions.PlayerNotFoundException;
import com.example.wallet.models.RequestPayload;
import com.example.wallet.models.Wallet;
import com.example.wallet.repositories.WalletRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService implements IWalletService {
    @Autowired
    private WalletRepository repository;

    @Override
    public List<Wallet> findAll() {
        List<Wallet> wallets = (List<Wallet>) repository.findAll();
        return wallets;
    }

    @Override
    public Wallet getBalance(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @Override
    public Wallet deposit(RequestPayload requestPayload) {
        return repository.findById(requestPayload.getPlayerId())
                .map(wallet -> {
                    var amount = requestPayload.getAmount();
                    wallet.setCashAmount(wallet.getCashAmount() + amount);
                    if (amount >= 100)
                        wallet.setBonusAmount(wallet.getBonusAmount() + amount);
                    return repository.save(wallet);
                })
                .orElseThrow(() -> new PlayerNotFoundException(requestPayload.getPlayerId()));
    }

    @Override
    public Wallet withdraw(RequestPayload requestPayload) {
        return repository.findById(requestPayload.getPlayerId())
                .map(wallet -> {
                    var amount = requestPayload.getAmount();
                    var walletCashAmount = wallet.getCashAmount();
                    if (walletCashAmount >= amount) {
                        wallet.setCashAmount(walletCashAmount - amount);
                    } else {
                        throw new NotEnoughFundsException();
                    }
                    return repository.save(wallet);
                })
                .orElseThrow(() -> new PlayerNotFoundException(requestPayload.getPlayerId()));
    }

    @Override
    public Wallet placeBet(RequestPayload requestPayload) {
        return repository.findById(requestPayload.getPlayerId())
                .map(wallet -> {
                    var requestAmount = requestPayload.getAmount();
                    var cashAmount = wallet.getCashAmount();
                    var bonusAmount = wallet.getBonusAmount();
                    var betCashAmount = 0;
                    var betBonusAmount = 0;

                    if (cashAmount >= requestAmount) {
                        wallet.setCashAmount(cashAmount - requestAmount);
                        betCashAmount += requestAmount;
                    } else {
                        wallet.setCashAmount(0);
                        betCashAmount += cashAmount;

                        if (bonusAmount >= requestAmount - betCashAmount) {
                            wallet.setBonusAmount(bonusAmount - (requestAmount - betCashAmount));
                            betBonusAmount += requestAmount - betCashAmount;
                        } else {
                            throw new NotEnoughFundsException();
                        }
                    }
                    repository.save(wallet);
                    return new Wallet(wallet.getPlayer(), betCashAmount, betBonusAmount);
                })
                .orElseThrow(() -> new PlayerNotFoundException(requestPayload.getPlayerId()));
    }
}
