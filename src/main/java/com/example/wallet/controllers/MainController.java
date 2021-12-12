package com.example.wallet.controllers;

import java.util.List;

import com.example.wallet.models.Bet;
import com.example.wallet.models.Player;
import com.example.wallet.models.RequestPayload;
import com.example.wallet.models.Transaction;
import com.example.wallet.models.Wallet;
import com.example.wallet.services.BetService;
import com.example.wallet.services.PlayerService;
import com.example.wallet.services.TransactionService;
import com.example.wallet.services.WalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private WalletService walletService;
    @Autowired
    private BetService betService;

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
      return playerService.findAll();
  }
  
    @GetMapping("/balance/{id}")
    public Wallet balance(@PathVariable Long id) {
      return walletService.getById(id);
    }
  
    @PostMapping("/deposit")
    public Wallet deposit(@RequestBody RequestPayload requestPayload) {
      return walletService.deposit(requestPayload);
    }
  
    @PostMapping("/withdraw")
    public Wallet withdraw(@RequestBody RequestPayload requestPayload) {
      return walletService.withdraw(requestPayload);
    }
  
    @PostMapping("/bet")
    public Bet bet(@RequestBody RequestPayload requestPayload) {
      var bet = walletService.placeBet(requestPayload);
      return betService.createBet(bet.getPlayer(), bet.getCashAmount(), bet.getBonusAmount());
    }
  
    @PostMapping("/win")
    public Wallet win(@RequestBody RequestPayload requestPayload) {
      return betService.finalizeBet(requestPayload, true);
    }
    
    @PostMapping("/lose")
    public Wallet lose(@RequestBody RequestPayload requestPayload) {
      return betService.finalizeBet(requestPayload, false);
    }  
}
