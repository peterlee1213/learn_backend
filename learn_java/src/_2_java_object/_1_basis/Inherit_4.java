package _2_java_object._1_basis;

/**
 * [面向对象编程/面向对象基础/继承]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1260454548196032
 */
public class Inherit_4 {
	public static void main(String[] args) {
		Inherit_4.instanceofUseCase();
	}

	// private的字段和方法不会被子class继承
	public static void publicProtectedPrivate() {
		StudentClass s = new StudentClass();
	}

	// super关键字可表示父类，仅用于调用父类构造方法
	public static void superUseCase() {
		Student1 s = new Student1("zheng", 17);
	}

	// final修饰的类不能被继承
	// （from java 15）sealed修饰的类必须通过permits关键字写出能够从该class继承的子类
	public static void sealedUseCase() {
		SealedSubClass s = new SealedSubClass();
	}

	// 向上转型: 子类实例可赋值给父类类型变量
	public static void upCastingUseCase() {
		Person2 p = new Student2();
	}

	// 向下转型会失败，可使用instanceof关键字来判断某实例是否属于/可转型为特定的class
	public static void instanceofUseCase() {
		Person2 p1 = new Person2();
		Person2 p2 = new Student2();

		System.out.println(p1 instanceof Person2); // true
		System.out.println(p1 instanceof Student2); // false
		System.out.println(p2 instanceof Person2); // true
		System.out.println(p2 instanceof Student2);// true
	}
}

class PersonClass {
	public String name;
	protected int age;
	private byte gender; // 0 for female; 1 for male

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	protected void setAge(int age) {
		this.age = age;
	}

	protected int getAge() {
		return this.age;
	}

	private void setGender(byte gender) {
		this.gender = gender;
	}

	private byte getGender() {
		return this.gender;
	}
}

class StudentClass extends PersonClass {
	private int score;

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void test() {
		// this.getGender(); //报错，private不能被继承
	}
}

final class Person1 {
	public String name;

	public Person1(String name) {
		this.name = name;
	}
}

// 此类会报错
class Student1 extends Person1 {
	public int score;

	public Student1(String name, int score) {
		super();
		this.score = score;
	}
}

sealed class SealedClass permits SealedSubClass {
}

final class SealedSubClass extends SealedClass {

}

class Person2 {

}

class Student2 extends Person2 {

}