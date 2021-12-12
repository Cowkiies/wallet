package com.example.wallet.exceptions;

public class BetNotFoundException extends RuntimeException {
    public BetNotFoundException(Long id) {
        super("Bet " + id + " not found");
    }
}
