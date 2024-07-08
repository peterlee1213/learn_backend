package _2_java_object._1_basis;

/**
 * [面向对象编程/面向对象基础/接口]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1260456790454816#0
 */
public class Interface_7 {
    public static void main(String[] args) {
        Interface_7.interfaceUseCase();
        Interface_7.implementsMultipleInterfaces();
        Interface_7.interfaceExtendsCase();
        Interface_7.interfaceDefaultMethodExample();

    }

    // interface使用案例
    public static void interfaceUseCase() {
        Student s = new Student();
        s.run();
        s.say("hello");
    }

    // 一个class可implements多个interface
    public static void implementsMultipleInterfaces() {
        ImplementsMultipleInterfaces i = new ImplementsMultipleInterfaces();
        i.test1();
        i.test2();
    }

    // interface之间可使用extends关键字相互继承
    public static void interfaceExtendsCase() {
        ChildInterfaceImplement c = new ChildInterfaceImplement();
        c.parent();
        c.child();
    }

    // interface的default方法可以写逻辑
    public static void interfaceDefaultMethodExample() {
        InterfaceDefaultExampleClass i = new InterfaceDefaultExampleClass();
        i.run();
    }

}

interface Person {
    void run();

    void say(String str);
}

class Student implements Person {
    public void run() {
        System.out.println("Student run");
    }

    public void say(String s) {
        System.out.println(s);
    }
}

interface Interface1 {
    void test1();
}

interface Interface2 {
    void test2();
}

class ImplementsMultipleInterfaces implements Interface1, Interface2 {
    public void test1() {
        System.out.println("test1");
    }

    public void test2() {
        System.out.println("test2");
    }
}

interface ParentInterface {
    void parent();
}

interface ChildInterface extends ParentInterface {
    void child();
}

class ChildInterfaceImplement implements ChildInterface {
    public void parent() {
        System.out.println("parent interface");
    };

    public void child() {
        System.out.println("child interface");
    }
}

interface InterfaceDefaultExample {
    String getName();

    default void run() {
        System.out.println(getName() + " running");
    }
}

class InterfaceDefaultExampleClass implements InterfaceDefaultExample {
    @Override
    public String getName() {
        return "Li";
    }
}
