package _2_java_object._1_basis;

import _2_java_object._1_basis.Scope_10_subfiles.Test;

/**
 * [面向对象编程/面向对象基础/作用域]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1260466215676512#0
 * 
 * 
 * 总结:
 * public的class可在任何包中被import，不带修饰符的class只在当前包中可用
 * 
 * public的字段和方法在任何包中都可被继承和实例访问
 * protected的字段和方法只能在当前包中被继承和实例访问
 * private的字段和方法只能在当前class中被访问
 */
public class Scope_10 {
    public static void main(String[] args) {

    }

    // protected字段和方法在不同包的java文件的实例中无法访问
    public static void protectedDifferentPackage() {
        Test t = new Test();
        // System.out.println(t.name); //报错，无法访问变量
    }

    // protected字段和方法在不同包的java文件的class中继承不过来
    public static void protectedDifferentPackageExtends() {
        ChildTest c = new ChildTest();
        // System.out.println(c.name); //报错，无法访问变量
    }
}

class ChildTest extends Test {
}