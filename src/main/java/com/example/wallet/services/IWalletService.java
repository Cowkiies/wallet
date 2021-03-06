package com.example.wallet.services;

import java.util.List;

import com.example.wallet.models.RequestPayload;
import com.example.wallet.models.Wallet;

public interface IWalletService {
    public List<Wallet> findAll();
    public Wallet getById(Long id);
    public Wallet saveWallet(Wallet wallet);
    public Wallet deposit(RequestPayload requestPayload);
    public Wallet withdraw(RequestPayload requestPayload);
    public Wallet placeBet(RequestPayload requestPayload);
}
