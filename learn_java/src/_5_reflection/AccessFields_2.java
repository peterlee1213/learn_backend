package _5_reflection;

import java.lang.Class;
import java.lang.reflect.Field;
/**
 * [反射/访问字段]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1264803033837024#0
 */
public class AccessFields_2 {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		getFieldsFromClassInstance();
	}
	
	public static void getFieldsFromClassInstance() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<Students> stuClass = Students.class;
		//获取指定字段的信息
		Field scoreField = stuClass.getField("score");
		//获取此类中所有public字段（包括继承的）
		Field[] publicFieldsArr = stuClass.getFields();
		//获取所有在此类中声明的字段（不包括继承的）
		Field[] declaredFieldsArr = stuClass.getDeclaredFields();
		System.out.println("");
		
		Person p = new Person("Xiaoming");
		Class<Person> perClass = Person.class;
		Field nameField = perClass.getDeclaredField("name");
		//可通过此方法获取特定实例的某个字段的值，但是不能超越权限，否则会得到IllegalAccessException
		Object o = nameField.get(p);
		System.out.println("");
		
		
	}

}

class Students extends Person{
	public int score;
	private int grade;
	
	Students(String name,int score, int grade){
		super(name);
		this.score = score;
		this.grade = grade;
	}
}

class Person {
	private String name;
	
	Person(String name){
		this.name = name;
	}
}
