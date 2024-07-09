package com.powernode.bank.dao;

import org.apache.ibatis.session.SqlSession;

import com.powernode.bank.pojo.Account;

public interface AccountDao {

    public Account selectByActno(String actno);

    public int updateByActno(Account act);

}
