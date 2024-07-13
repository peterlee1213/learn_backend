import org.junit.Test;

import com.powernode.RecordClass;

public class TestClass {
    @Test
    /**
     * record 只能读不能写
     */
    public void testRecord() {
        RecordClass rc = new RecordClass("zheng", 13);
        System.out.println(rc.name());
        System.out.println(rc.age());
    }
}
