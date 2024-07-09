package com.powernode.bank.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {

    public static SqlSessionFactory sqlSessionFactory = null;
    public static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    private SqlSessionUtil() {
    }

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession get() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    // 当前线程要结束的话一定要及时从Map中移除键值对,否则这个全局的ThreadLocal对象会越来越大,直至内存溢出
    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
            threadLocal.remove();
        }
    }
}
