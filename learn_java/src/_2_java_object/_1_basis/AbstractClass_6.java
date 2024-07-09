package _2_java_object._1_basis;

/**
 * [面向对象编程/面向对象基础/抽象类]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1260456371027744
 */
public class AbstractClass_6 {
    public static void main(String[] args) {
        AbstractClass_6.abstractClassUseCase();
    }

    // 抽象方法必须被复写，抽象类相当于定义了规范
    // abstract关键字只能用于class和方法
    public static void abstractClassUseCase() {
        Student s = new Student();
        s.run();
        s.test();
        System.out.println(s.name);
    }
}

abstract class AbstractPerson {

    // abstract String name; //报错，abstract关键字只能用于class和方法
    String name = "peter";

    public abstract void run();

    public void test() {
        System.out.println("test");
    }
}

class Student extends AbstractPerson {
    public void run() {
        System.out.println("Student run");
    }
}
