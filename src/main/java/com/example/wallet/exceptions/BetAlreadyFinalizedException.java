package com.example.wallet.exceptions;

public class BetAlreadyFinalizedException extends RuntimeException {
    public BetAlreadyFinalizedException(Long id) {
        super("Bet " + id + " already finalized");
    }
}
