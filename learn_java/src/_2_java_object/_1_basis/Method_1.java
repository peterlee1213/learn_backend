package _2_java_object._1_basis;

import java.util.Arrays;

/**
 * [面向对象编程/面向对象基础/方法]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1260452774408320
 */
public class Method_1 {
	public static void main(String[] args) {
		Method_1.newPrivilege();
		Method_1.functionParameters();
		Method_1.referenceTypeAsFunctionParams();
	}
	
	//new出来的实例是否可访问public/protected/private字段和方法
	public static void newPrivilege() {
		NewTest t1 = new NewTest();
		System.out.println(t1.publicField);
		System.out.println(t1.protectedField);
//		System.out.println(t1.privateField); //报错
		System.out.println(t1.getPublicField());
		System.out.println(t1.getProtectedField());
//		System.out.println(t1.getPrivateField());	//报错
	}
	
	//函数的各种传参方式
	public static void functionParameters() {
		Parameters p = new Parameters();
		//一般传参方式
		p.commonParameters("abc", 12, 3.45);
		//可变参数（不定长参数/任意长度的参数）
		p.variableLengthParameters();
		p.variableLengthParameters("abc");
		p.variableLengthParameters("abc","def","gty");
	}
	
	//引用类型参数的传递，调用方变量和接收方变量指向同一个对象，任何一方对对象的修改都会影响另外一个
	public static void referenceTypeAsFunctionParams() {
		Person p = new Person();
		String[] fullname = {"Peter","Lee"};
		p.setName(fullname);
		System.out.println(p.getName());
		fullname[0] = "motherfucker";
		System.out.println(p.getName());
	}
}

class NewTest {
	public String publicField = "s1";
	protected String protectedField = "s2";
	private String privateField = "s3";
	
	public String getPublicField() {
		return this.publicField;
	}
	protected String getProtectedField() {
		return this.protectedField;
	}
	private String getPrivateField() {
		return this.privateField;
	}
}

class Parameters{
	public void commonParameters(String s, int i, double d) {
		System.out.printf("string: %s\n", s);
		System.out.printf("int: %d\n", i);
		System.out.printf("double: %f\n", d);
	}
	public void variableLengthParameters(String ...p) {
		System.out.println(Arrays.toString(p));
	}
}

class Person{
	private String[] name;
	
	public String getName() {
		return this.name[0]+ " " + this.name[1];
	}
	
	public void setName(String[] name) {
		this.name = name;
	}
}
