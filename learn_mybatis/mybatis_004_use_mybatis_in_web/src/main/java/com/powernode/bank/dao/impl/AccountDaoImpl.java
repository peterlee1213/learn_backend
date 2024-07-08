package com.powernode.bank.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.util.SqlSessionUtil;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.get();
        Account obj = (Account) sqlSession.selectOne("act.getOneByActno", actno);
        return obj;
    }

    @Override
    public int updateByActno(Account act) {
        SqlSession sqlSession = SqlSessionUtil.get();
        int count = sqlSession.update("act.updateOne", act);
        return count;
    }

}
