import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.powernode.bank.service.AccountService;

public class FundamentalTransactionTest {
    @Test
    public void testTx() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccountService bean = context.getBean("accountService", AccountService.class);
        bean.transfer("act-001", "act-002", 1000.0);
    }
}
