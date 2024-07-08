package _5_reflection;

public class GetExtendRelationship_4 {
	public static void main(String[] args) {
		String s = "";
		Class cls = s.getClass();
		
		//获取父类的class
		Class superClass = cls.getSuperclass();
		System.out.println("");
		
		//一个类会实现一个或多个接口，可通过Class查询某个类实现的接口
		Class intClass = Integer.class;
		Class[] intInterfaces = intClass.getInterfaces();
		System.out.println("");
	}
}
