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

    private Integer bonusAmount;
    private Integer cashAmount;

    @Enumerated(EnumType.STRING)
    private BetStatus status;


    public Bet() {
        super();
    }

    public Bet(Player player, Integer cashAmount, Integer bonusAmount, BetStatus status) {
        this.player = player;
        this.cashAmount = cashAmount;
        this.bonusAmount = bonusAmount;
        this.status = status;
    }

    public Integer getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(Integer bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public Integer getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Integer cashAmount) {
        this.cashAmount = cashAmount;
    }

    public BetStatus getStatus() {
        return status;
    }

    public void setStatus(BetStatus status) {
        this.status = status;
    }
}
