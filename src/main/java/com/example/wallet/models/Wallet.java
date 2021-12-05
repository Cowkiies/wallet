package com.example.wallet.models;

import javax.persistence.*;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @Column(name = "player_id")
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "player_id")
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
