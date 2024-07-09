package _5_reflection;

import java.lang.reflect.Method;
/**
 * [反射/调用方法]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1264803678201760#0
 */
public class CallMethods_3 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		example();
	}
	
	public static void example() throws NoSuchMethodException, SecurityException {
		Class stuClass = StudentMethod.class;
		
		//获取这个类下所有的public methods
		Method[] stuMethods = stuClass.getMethods();
		//获取这个类下特定的method
		Method stuMethod = stuClass.getMethod("getName");
		
		System.out.println("");
	}
}

class StudentMethod extends PersonMethod{
	public int getScore(String type) {
		return 99;
	}
	
	private int getGrade(int year) {
		return 1;
	}
}


class PersonMethod{
	public String getName() {
		return "Person";
	}
}