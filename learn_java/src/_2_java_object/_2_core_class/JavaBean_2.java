package _2_java_object._2_core_class;

import java.beans.BeanInfo;
import java.beans.Introspector;

/**
 * [面向对象编程/Java核心类/JavaBean]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1260474416351680
 */
public class JavaBean_2 {
    public static void main(String[] args) {
        JavaBeanClass j = new JavaBeanClass();
        j.setName("peter");
        j.setAdult(true);
        System.out.println(j.getName());
        System.out.println(j.isAdult());
    }
}

class JavaBeanClass {
    private String name;
    private boolean adult;

    // 除了boolean之外的bean用get
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // boolean类型的bean用is
    public boolean isAdult() {
        return this.adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }
}