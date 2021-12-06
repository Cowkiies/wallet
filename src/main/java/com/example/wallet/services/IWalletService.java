package com.example.wallet.services;

import java.util.List;

import com.example.wallet.models.Wallet;

public interface IWalletService {
    public List<Wallet> findAll();
}
