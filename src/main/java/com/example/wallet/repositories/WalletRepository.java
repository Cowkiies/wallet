package com.example.wallet.repositories;

import com.example.wallet.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository  extends JpaRepository<Wallet, Integer>{
    
}
