package com.example.wallet.repositories;

import com.example.wallet.models.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long>{
    
}
