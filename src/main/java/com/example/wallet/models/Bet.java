package com.example.wallet.models;

import javax.persistence.*;

import com.example.wallet.enums.BetStatus;

@Entity
@Table(name = "bets")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    private float bonusAmount;
    private float cashAmount;

    @Enumerated(EnumType.STRING)
    private BetStatus status;


    public Bet() {
        super();
    }

    public Bet(Player player, float cashAmount, float bonusAmount, BetStatus status) {
        this.player = player;
        this.cashAmount = cashAmount;
        this.bonusAmount = bonusAmount;
        this.status = status;
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

    public BetStatus getStatus() {
        return status;
    }

    public void setStatus(BetStatus status) {
        this.status = status;
    }

    public Long getPlayerId() {
        return player.getId();
    }
}
