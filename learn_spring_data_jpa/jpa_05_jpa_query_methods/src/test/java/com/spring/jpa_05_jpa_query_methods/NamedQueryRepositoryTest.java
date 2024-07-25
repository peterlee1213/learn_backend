package com.spring.jpa_05_jpa_query_methods;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.jpa_05_jpa_query_methods.domain.Employees;
import com.spring.jpa_05_jpa_query_methods.repositories.NamedQueryRepository;

@SpringBootTest
public class NamedQueryRepositoryTest {

    @Autowired
    private NamedQueryRepository nqr;

    @Test
    public void testSimpleNamedQuery() {
        List<Employees> list = nqr.simpleNamedQuery("feller");
        System.out.println(list);
    }

}
