package com.example.wallet.repositories;

import com.example.wallet.models.Bet;
import org.springframework.data.repository.CrudRepository;

public interface BetRepository extends CrudRepository<Bet, Long>{
    
}
