package com.powernode.bank.service;

import com.powernode.bank.exception.MoneyInsufficientException;

public interface AccountService {

    /**
     * transfer money
     * 
     * @param fromActno transfer from which account
     * @param toActno   transfer to which account
     * @param money     how much money is transfered
     */
    void transfer(String fromActno, String toActno, double money) throws MoneyInsufficientException;

}
