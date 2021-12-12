package com.example.wallet.models;

public class RequestPayload {
    private Long transactionId;
    private Long playerId;
    private Integer amount;
    private Long betId;

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
      }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
      }

    public Long getPlayerId() {
        return playerId;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
      }

    public Integer getAmount() {
        return amount;
    }

    public Long getBetId() {
      return betId;
    }

    public void setBetId(Long betId) {
      this.betId = betId;
    }

    public RequestPayload setNegativeAmount() {
      this.amount = -amount;
      return this;
    }
}
