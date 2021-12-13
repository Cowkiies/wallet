package com.example.wallet.models;

import javax.persistence.*;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    private float bonusAmount;
    private float cashAmount;

    public Wallet() {
        super();
    }

    public Wallet(Player player, float cashAmount, float bonusAmount) {
        this.player = player;
        this.cashAmount = cashAmount;
        this.bonusAmount = bonusAmount;
    }

    public float getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(float bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public float getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(float cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Player getPlayer() {
        return player;
    }
}
