package _2_java_object._1_basis.PackageZone_9;

/**
 * [面向对象编程/面向对象基础/包]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1260467032946976#0
 */
public class Main {
    public static void main(String[] args) {

    }

    // 同一个包下的的class可以直接用
    public static void useClassFromTheSamePackage() {
        // 来自./Test.java
        Test t = new Test();
        t.run();
        ProtectedTest p = new ProtectedTest();
        p.protectedTestRun();
    }
}
