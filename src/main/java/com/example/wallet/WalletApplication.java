
package com.example.wallet;

import java.util.List;

import com.example.wallet.models.Player;
import com.example.wallet.repositories.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WalletApplication {
  @Autowired
  private PlayerRepository playerRepo;
  public static void main(String[] args) {
    SpringApplication.run(WalletApplication.class, args);
  }

  @GetMapping("/transactions")
  public String transactions(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }

  @GetMapping("/players")
  public List<Player> listAll(Model model) {
    List<Player> listPlayers = playerRepo.findAll();
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
