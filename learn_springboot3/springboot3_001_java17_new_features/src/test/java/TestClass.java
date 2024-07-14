import org.junit.Test;

import com.powernode.RecordClass;
import com.powernode.SwitchClass;

public class TestClass {
    @Test
    /**
     * record 只能读不能写
     */
    public void testRecord() {
        RecordClass rc = new RecordClass("zheng", 13);
        System.out.println(rc.name());
        System.out.println(rc.age());
        System.out.println(rc.toString());
    }

    /**
     * 测试switch箭头表达式最基本的用法
     */
    @Test
    public void testBasicArrowExpression() {
        SwitchClass sc = new SwitchClass();
        sc.testBasicArrowExpression();
    }

    /**
     * yield赋值用法
     */
    @Test
    public void testYield() {
        SwitchClass sc = new SwitchClass();
        sc.testYield();
    }

}
