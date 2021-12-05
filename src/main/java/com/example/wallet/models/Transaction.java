package com.example.wallet.models;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    private Integer amount;
    private Timestamp dateUtc;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Timestamp getDateUtc() {
        return dateUtc;
    }

    public void setDateUtc(Timestamp dateUtc) {
        this.dateUtc = dateUtc;
    }
}