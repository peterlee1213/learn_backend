package _2_java_object._1_basis;

/**
 * [面向对象编程/面向对象基础/内部类]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1376414781669409#0
 */
public class InnerClass_11 {
    public static void main(String[] args) {
        InnerClass_11.innerClassCommonUseCase();
        InnerClass_11.staticInnerClassCommonUseCase();
    }

    // 内部类一般使用方式
    public static void innerClassCommonUseCase() {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.hello();
    }

    // 静态内部类的一般使用方式
    public static void staticInnerClassCommonUseCase() {
        StaticOuterClass.StaticInnerClass s = new StaticOuterClass.StaticInnerClass();
        s.run();
    }
}

class Outer {
    class Inner {
        public void hello() {
            System.out.println("hello");
        }
    }
}

class AnonymousOuter {
    private String name;

    public AnonymousOuter(String name) {
        this.name = name;
    }

    void asyncHello() {
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Hello, " + AnonymousOuter.this.name);
            }
        };
        new Thread(r).start();
    }
}

class StaticOuterClass {
    static class StaticInnerClass {
        void run() {
            System.out.println("static inner class running");
        }
    }
}