package _2_java_object._1_basis;

/**
 * [面向对象编程/面向对象基础/静态字段和静态方法]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1260464690677856#0
 */
public class StaticFieldAndMethod_8 {
    public static void main(String[] args) {
        StaticFieldAndMethod_8.interfaceWithStaticFields();
    }

    public static void interfaceWithStaticFields() {
        System.out.println(InterfaceWithStaticFields.FEMALE);
    }
}

interface InterfaceWithStaticFields {
    public static final int MALE = 1;
    // 没写前缀等同于上面一行的前缀
    int FEMALE = 2;
}
