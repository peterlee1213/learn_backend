import org.junit.Test;

import com.powernode.bank.service.AccountService;
import com.powernode.bank.service.impl.AccountServiceImpl;

public class Client {
    @Test
    /**
     * 模拟客户端发送请求
     */
    public void client() {
        AccountService accountService = new AccountServiceImpl();
        accountService.transfer("act001", "act002", 1000.0);
    }
}
