import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.powernode.doublesingletonwithset.Husband;
import com.powernode.doublesingletonwithset.Wife;

public class TestLifeCycle {
    @Test
    public void doubleSingletonWithSet() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("doubleSingletonWithSet.xml");
        Husband husbandBean = applicationContext.getBean("husbandBean", Husband.class);
        Wife wifeBean = applicationContext.getBean("wifeBean", Wife.class);
        System.out.println("" + husbandBean + wifeBean);
    }
}
