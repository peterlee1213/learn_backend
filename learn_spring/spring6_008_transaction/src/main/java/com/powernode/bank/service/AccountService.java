package com.powernode.bank.service;

/**
 * 业务接口, 事务就是在这个接口下执行的
 */
public interface AccountService {
    /**
     * 
     * @param fromActno 从这个账号转出
     * @param toActno   转入这个账户
     * @param money     转多少钱
     */
    void transfer(String fromActno, String toActno, Double money);
}
