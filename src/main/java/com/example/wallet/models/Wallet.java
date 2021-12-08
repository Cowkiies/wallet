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

    private Integer bonusAmount;
    private Integer cashAmount;

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
}
