package com.example.wallet.exceptions;

public class TransactionAlreadyExistsException  extends RuntimeException {
    public TransactionAlreadyExistsException(Long id) {
        super("Transaction " + id + " already exists");
    }
}
