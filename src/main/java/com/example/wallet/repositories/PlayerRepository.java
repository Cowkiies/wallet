package com.example.wallet.repositories;

import com.example.wallet.models.Player;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long>{
    public Page<Player> findAll(Pageable pageable);
    public Page<Player> findByFirstNameOrLastName(String firstName, String lastName, Pageable pageable);
}
