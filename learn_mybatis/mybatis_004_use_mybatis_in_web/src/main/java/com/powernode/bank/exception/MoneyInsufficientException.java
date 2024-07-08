package com.powernode.bank.exception;

public class MoneyInsufficientException extends RuntimeException {
    public MoneyInsufficientException(String errorMsg) {
        super(errorMsg);
    }
}
