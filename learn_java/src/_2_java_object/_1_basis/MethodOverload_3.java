package _2_java_object._1_basis;

/**
 * [面向对象编程/面向对象基础/方法重载]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1260454256258656
 */
public class MethodOverload_3 {
	public static void main(String[] args) {
		OverloadClass o = new OverloadClass();
		o.hello();
		o.hello("Peter");
		o.hello("Peter", "Lee");
	}
}

class OverloadClass {
	public void hello() {
		System.out.println("Hello, world");
	}

	public void hello(String name) {
		System.out.println("Hello, " + name);
	}

	public void hello(String firstname, String lastname) {
		System.out.println("Hello, " + firstname + " " + lastname);
	}
}
