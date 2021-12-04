package com.example.wallet.repositories;

import com.example.wallet.models.Player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
    
}
