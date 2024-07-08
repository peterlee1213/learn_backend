import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.powernode.Spring6Config;
import com.powernode.example.User;

@RunWith(SpringJUnit4ClassRunner.class) // 此类下使用JUnit4来跑测试
@ContextConfiguration("classpath:spring.xml") // 这里指定过后就无需频繁new ClassPathXmlApplicationContext("spring.xml")
public class JunitTest {

    @Autowired
    @Qualifier("user")
    private User user;

    @Test
    public void testJunit() {

        System.out.println(this.user.toString());
    }
}
