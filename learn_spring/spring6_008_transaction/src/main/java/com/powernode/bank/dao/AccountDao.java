package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

/**
 * 专门负责账户的crud操作
 * DAO只执行sql语句,没有任何业务逻辑
 */
public interface AccountDao {
    /**
     * 根据账号查询账号信息
     * 
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户
     * 
     * @param actno
     * @return
     */
    int updateByActno(Account act);
}
