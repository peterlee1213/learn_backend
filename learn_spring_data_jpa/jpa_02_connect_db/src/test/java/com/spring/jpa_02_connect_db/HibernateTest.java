package com.spring.jpa_02_connect_db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.jpa_02_connect_db.domain.Customer;

@SpringBootTest
public class HibernateTest {

    @Autowired
    private SessionFactory sf;

    @Test
    public void testCreate() {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = new Customer(null, "zhangsan", "shandong");
            session.save(customer);
            transaction.commit();
        } catch (Exception e) {
        }
    }

    @Test
    public void testFind() {
        try (Session session = sf.openSession();) {
            Transaction transaction = session.beginTransaction();
            // System.out.println(session.find(Customer.class, 1L));
            Customer customer = session.load(Customer.class, 1L);
            System.out.println("=====================");
            System.out.println(customer);
            transaction.commit();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Test
    public void testUpdate() {
        try (Session session = sf.openSession();) {
            Transaction transaction = session.beginTransaction();
            Customer customer = new Customer(1L, "lisi", "abc");
            // 插入
            // session.save();
            // 更新
            // session.update();
            // 删除
            // session.delete();
            // 有主键id会自动更新，没有就自动插入
            session.saveOrUpdate(customer);
            transaction.commit();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
