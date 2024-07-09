package miscellaneous.interface_related;

/**
 * new一个interface表示使用此接口创建一个类, 然后使用这个类创建一个实例
 */
public class WhatDoesNewInterfaceMean {
    public static void main(String... args) {
        TestInterface t = new TestInterface() {
            // 必须加public前缀, 否则匿名内部类的属性和方法是不可见的
            public void test() {
                System.out.println("test interface");
            }
        };
        t.test();
    }
}

interface TestInterface {
    public void test();
}
