package com.powernode.bank.exception;

public class SqlSessionCreateError extends RuntimeException {
    public SqlSessionCreateError() {
    }

    public SqlSessionCreateError(String error) {
        super(error);
    }
}
