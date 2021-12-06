package com.example.wallet.services;

import java.util.List;

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
}
