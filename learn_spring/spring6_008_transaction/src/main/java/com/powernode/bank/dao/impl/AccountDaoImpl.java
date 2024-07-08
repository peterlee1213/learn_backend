package com.powernode.bank.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;

import jakarta.annotation.Resource;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByActno(String actno) {
        String sql = "select * from t_user where actno =?";
        Account queryForObject = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class),
                actno);
        return queryForObject;
    }

    @Override
    public int updateByActno(Account act) {
        String sql = "update t_user set balance = ? where actno = ?";
        int update = jdbcTemplate.update(sql, act.getBalance(), act.getActno());
        return update;
    }

}
