package com.example.wallet.models;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    private float amount;
    private Timestamp dateUtc;


    public Transaction() {  
        super();
    }

    public Transaction(Long id, Player player, float amount, Timestamp dateUtc) {
        this.id = id;
        this.player = player;
        this.amount = amount;
        this.dateUtc = dateUtc;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Timestamp getDateUtc() {
        return dateUtc;
    }

    public void setDateUtc(Timestamp dateUtc) {
        this.dateUtc = dateUtc;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
