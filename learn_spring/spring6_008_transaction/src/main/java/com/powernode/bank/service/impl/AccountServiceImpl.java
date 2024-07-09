package com.powernode.bank.service.impl;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;

import jakarta.annotation.Resource;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transfer(String fromActno, String toActno, Double money) {
        // 1. 开启事务
        // 2. 业务逻辑
        Account act1 = accountDao.selectByActno(fromActno);
        if (act1.getBalance() < money) {
            throw new RuntimeException("余额不足");
        }

        Account act2 = accountDao.selectByActno(toActno);

        act1.setBalance(act1.getBalance() - money);
        act2.setBalance(act2.getBalance() + money);

        int count = accountDao.updateByActno(act1);

        // String s = null;
        // s.toString();

        count += accountDao.updateByActno(act2);

        if (count != 2) {
            throw new RuntimeException("转账失败");
        }

        // 3. 提交事务
        // 4. 如果有Exception回滚

    }

}
