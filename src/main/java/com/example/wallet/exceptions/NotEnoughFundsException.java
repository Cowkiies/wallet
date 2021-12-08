package com.example.wallet.exceptions;

public class NotEnoughFundsException extends RuntimeException {
    public NotEnoughFundsException() {
        super("Insufficient cash fund");
    }
}
