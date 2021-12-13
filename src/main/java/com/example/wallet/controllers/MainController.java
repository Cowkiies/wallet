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

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
  public List<Transaction> transactions(
      @RequestParam(required = false) Long playerId,
      @RequestParam(defaultValue = "1970-01-01T00:00:00Z") String dateFrom,
      @RequestParam(defaultValue = "2100-01-01T00:00:00Z") String dateTo,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size
  ) {
    Pageable paging = PageRequest.of(page, size);
    List<Transaction> transactions;

    if (playerId != null) {
      transactions = transactionService.findByDateUtcBetweenAndPlayerId(dateTo, dateFrom, playerId, paging);
    } else {
      transactions = transactionService.getAllBetweenDates(dateFrom, dateTo, paging);
    }

    return transactions;
  }

  @GetMapping("/transactions/{id}")
  public Transaction transactionById(@PathVariable Long id) {
    return transactionService.findById(id);
  }

  @GetMapping("/players")
  public List<Player> players(
      @RequestParam(required = false) String firstName,
      @RequestParam(required = false) String lastName,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size
      ) {
    List<Player> players;
    Pageable paging = PageRequest.of(page, size);

    if (firstName != null || lastName != null) {
      players = playerService.findByFirstNameOrLastName(firstName, lastName, paging);
    } else {
      players = playerService.findAll(paging);
    }

    return players;
  }

  @GetMapping("/players/{id}")
  public Player playerById(@PathVariable Long id) {
    return playerService.findById(id);
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
