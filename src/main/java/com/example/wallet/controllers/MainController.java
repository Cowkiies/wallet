package com.example.wallet.controllers;

import java.util.List;

import com.example.wallet.models.Player;
import com.example.wallet.models.Transaction;
import com.example.wallet.services.PlayerService;
import com.example.wallet.services.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TransactionService transactionService;

    public MainController() {
    }

    @GetMapping("/transactions")
    public List<Transaction> transactions(Model model) {
      List<Transaction> listTransactions = (List<Transaction>) transactionService.findAll();
      model.addAttribute("listTransactions", listTransactions);  
      return listTransactions;
    }
  
    @GetMapping("/players")
    public List<Player> listAll(Model model) {
      List<Player> listPlayers = (List<Player>) playerService.findAll();
      model.addAttribute("listPlayers", listPlayers);  
      return listPlayers;
  }
  
    @GetMapping("/balance")
    public String balance(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }
  
    @PostMapping("/deposit")
    public String deposit(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }
  
    @PostMapping("/withdraw")
    public String withdraw(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }
  
    @PostMapping("/bet")
    public String bet(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }
  
    @PostMapping("/win")
    public String win(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }  
}
