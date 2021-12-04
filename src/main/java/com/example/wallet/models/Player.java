package com.example.wallet.models;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String playerName;

    public String getPlayerName() {
        return playerName;
      }
    
      public void setPlayerName(String playerName) {
        this.playerName = playerName;
      }
}
