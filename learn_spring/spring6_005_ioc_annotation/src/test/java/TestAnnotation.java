import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.powernode.Spring6Config;
import com.powernode.example.User;
import com.powernode.inject.AutowiredAndQualifier;
import com.powernode.inject.SimpleValue;
import com.powernode.inject.ValueOnConstructor;
import com.powernode.inject.ValueOnSetter;

public class TestAnnotation {
    @Test
    // 测试最基本的将class声明为bean
    public void testBaseAnnotation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("instantiate.xml");
        User bean = applicationContext.getBean("userBean", User.class);
        System.out.println(bean);
    }

    @Test
    // 测试@Value注入
    // @Value只能注入简单类型
    public void testValueInjection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("inject.xml");

        // @Value用在属性值上
        SimpleValue bean = applicationContext.getBean("simpleValue", SimpleValue.class);
        System.out.println(bean);

        // @Value用在Setter方法上
        ValueOnSetter bean1 = applicationContext.getBean("valueOnSetter", ValueOnSetter.class);
        System.out.println(bean1);

        // @Value用在构造方法上
        ValueOnConstructor bean2 = applicationContext.getBean("valueOnConstructor", ValueOnConstructor.class);
        System.out.println(bean2);
    }

    @Test
    /*
     * @Autowired可实现按类型自动装配
     * 
     * @Autowired跟@Qualifier同时使用可实现按名称进行自动装配
     */
    public void testAutowiredAndQualifier() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("inject.xml");
        AutowiredAndQualifier bean2 = applicationContext.getBean("autowiredAndQualifier", AutowiredAndQualifier.class);
        System.out.println(bean2);
    }

    @Test
    /*
     * 可写一个java class文件来代替整个xml文件,具体参照com.powernode.Spring6Config
     */
    public void testNoXML() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
        ValueOnConstructor bean = context.getBean("valueOnConstructor", ValueOnConstructor.class);
        System.out.println(bean);
    }
}
