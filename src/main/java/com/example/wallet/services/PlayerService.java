package com.example.wallet.services;

import java.util.List;

import com.example.wallet.exceptions.PlayerNotFoundException;
import com.example.wallet.models.Player;
import com.example.wallet.repositories.PlayerRepository;
import org.springframework.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private PlayerRepository repository;

    @Override
    public List<Player> findAll(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    @Override
    public List<Player> findByFirstNameOrLastName(String firstName, String lastName, Pageable pageable) {
        return repository.findByFirstNameOrLastName(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), pageable).getContent();
    }

    @Override
    public Player findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new PlayerNotFoundException(id));
    }
}
