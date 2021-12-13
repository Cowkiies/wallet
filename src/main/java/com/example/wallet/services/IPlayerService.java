package com.example.wallet.services;

import java.util.List;

import com.example.wallet.models.Player;

import org.springframework.data.domain.Pageable;

public interface IPlayerService {
    public List<Player> findAll(Pageable pageable);
    public Player findById(Long id);
    public List<Player> findByFirstNameOrLastName(String firstName, String lastName, Pageable pageable);
}
