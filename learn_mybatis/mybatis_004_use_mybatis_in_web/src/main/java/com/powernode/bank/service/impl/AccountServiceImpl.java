package com.powernode.bank.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.dao.impl.AccountDaoImpl;
import com.powernode.bank.exception.MoneyInsufficientException;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.util.SqlSessionUtil;

public class AccountServiceImpl implements AccountService {

    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyInsufficientException {

        SqlSession sqlSession = SqlSessionUtil.get();

        // 这是传统的手写DAO实现类, 我们不用这种方法
        // AccountDao accountDao = new AccountDaoImpl();

        // 这是通过mybatis代理自动生成DAO实现类的方法
        AccountDao accountDao = SqlSessionUtil.get().getMapper(AccountDao.class);

        Account fromAct = accountDao.selectByActno(fromActno);
        Account toAct = accountDao.selectByActno(toActno);

        if (fromAct.getBalance() < money) {
            throw new MoneyInsufficientException("No Enough Money");
        }

        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        int count = accountDao.updateByActno(fromAct);

        // String s = null;
        // s.toString();

        count += accountDao.updateByActno(toAct);
        sqlSession.commit();
        sqlSession.close();

        if (count == 2) {
            System.out.println("转账成功");
        } else {
            System.out.println("转账失败");
        }

    }

}
