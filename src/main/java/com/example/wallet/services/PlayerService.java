package com.example.wallet.services;

import java.util.List;

import com.example.wallet.models.Player;
import com.example.wallet.repositories.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private PlayerRepository repository;

    @Override
    public List<Player> findAll() {
        List<Player> players = (List<Player>) repository.findAll();
        return players;
    }
}
