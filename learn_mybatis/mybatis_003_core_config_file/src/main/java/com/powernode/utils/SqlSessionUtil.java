package com.powernode.utils;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {

    // 工具类的构造方法一般都是私有化的
    private SqlSessionUtil() {
    };

    // 工具类中所有的方法和变量一般都是静态的,方便调用
    public static SqlSessionFactory sessionFactory = null;

    static {
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static SqlSession get() {
        if (sessionFactory != null) {
            return sessionFactory.openSession();
        }
        return null;
    }
}
