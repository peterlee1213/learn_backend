import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.powernode.mynewhandovertospring.Student;

public class TestLifeCycle {

    @Test
    public void testFiveLifecycke() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("testLifeCycle5.xml");
        Object bean = applicationContext.getBean("userBean");
        System.out.println("4. use Bean");
        // 必须要手动关闭spring容器才能执行销毁bean的方法
        applicationContext.close();
    }

    @Test
    public void testSevenLifecycke() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("testLifeCycle7.xml");
        Object bean = applicationContext.getBean("userBean");
        System.out.println("4. use Bean");
        // 必须要手动关闭spring容器才能执行销毁bean的方法
        applicationContext.close();
    }


    /**
     * 我自己new的对象如何交给spring容器来管理
     */
    @Test
    public void myNewHandoverToSpring() {
        Student s = new Student();

        // 将自己new的对象交给spring容器管理
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("studentBean", s);

        // 从spring容器中获取
        Student bean = factory.getBean("studentBean", Student.class);

    }
}
