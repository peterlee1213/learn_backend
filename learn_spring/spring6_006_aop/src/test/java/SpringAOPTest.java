import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.powernode.Spring6Config;
import com.powernode.annotation.UserService;

public class SpringAOPTest {

    /**
     * 测试基于XML的注解开发
     * 
     * @throws Exception
     */
    @Test
    public void testAOP() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService bean = context.getBean("userService", UserService.class);
        bean.login();
        bean.logout();
        // bean.exceptionTest();
    }

    /**
     * 测试全注解开发
     */
    @Test
    public void testAOPAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
        UserService bean = context.getBean("userService", UserService.class);
        bean.login();
        bean.logout();
    }
}
