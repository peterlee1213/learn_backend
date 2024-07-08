package _8_collection;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;

/**
 * 集合/编写equals和hashCode
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265117217944672#0
 */
public class WriteEqualsAndHashCode_4 {
    public static void main(String[] args) {
        Map<Test4, Integer> m = new HashMap<>();
        m.put(new Test4("peter", 18), 1);
        m.put(new Test4("lee", 19), 2);
        System.out.println(m.get(new Test4("peter", 18))); // 1
    }

}

// 作为key的对象必须正确覆写equals方法,相等的两个key实例调用equals()必须返回true
// 作为key的对象必须正确覆写hashCode(),要保证如果两个key equals,hashCode也必须相等,key不相等则hashCode也不能相等
// 以下是覆写示例
class Test4 {
    public String name;
    public int age;

    Test4(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Test4) {
            Test4 oTest4 = (Test4) o;
            if (Objects.equals(oTest4.name, this.name) && this.age == oTest4.age) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.age);
    }
}
