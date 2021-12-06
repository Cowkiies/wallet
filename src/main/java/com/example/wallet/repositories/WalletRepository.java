package com.example.wallet.repositories;

import com.example.wallet.models.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository  extends CrudRepository<Wallet, Long>{
    
}
