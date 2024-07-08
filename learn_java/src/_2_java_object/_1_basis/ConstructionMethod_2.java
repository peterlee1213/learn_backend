package _2_java_object._1_basis;

/**
 * [面向对象编程/面向对象基础/构造方法]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1260454185794944
 */
public class ConstructionMethod_2 {
	public static void main(String[] args) {
		ConstructionMethod_2.multiConstruction();
		ConstructionMethod_2.constructionCallEachOther();
	}
	
	//一个class内部可同时定义多个构造函数
	public static void multiConstruction() {
		ConstructionTest1 c1 = new ConstructionTest1();
		System.out.println(c1.name);
		ConstructionTest1 c2 = new ConstructionTest1("Peter");
		System.out.println(c2.name);
	}
	
	//一个class内部的多个构造函数可以相互调用
	public static void constructionCallEachOther() {
		ConstructionTest2 t = new ConstructionTest2();
		System.out.println(t.name);
		System.out.println(t.age);
	}
}

class ConstructionTest1{
	String name;
	
	public ConstructionTest1() {
		this.name = "Unnamed";
	}
	public ConstructionTest1(String name) {
		this.name = name;
	}
}

class ConstructionTest2{
	String name;
	int age;
	
	public ConstructionTest2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public ConstructionTest2(String name) {
		//调用上面传两个参数的那个构造函数
		this(name, 999);
	}
	
	public ConstructionTest2() {
		//调用上面传一个参数的构造函数
		this("Unnamed");
	}
}
