package com.powernode.utils;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
    public static SqlSessionFactory sqlSessionFactory;
    public static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    private SqlSessionUtil() {
    }

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
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

    public static void close() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession != null) {
            threadLocal.remove();
            sqlSession.close();
        }
    }
}
