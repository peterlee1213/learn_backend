package _6_annotation;

/**
 * 注解/使用注解
 * 
 * 
 */
public class UseAnnotation_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.connectDb();
	}
	
	public static void annotationExample() {
	}

}

@TestAnnotation(userName = "root", password="root",port=3306, address="db.happ.com")
class Test{
	public void connectDb() {
		Class<Test> t = Test.class;
		if(t.isAnnotationPresent(TestAnnotation.class)) {
			TestAnnotation ta = t.getAnnotation(TestAnnotation.class);
			String userName = ta.userName();
			String password = ta.password();
			int port = ta.port();
			String address = ta.address();
			System.out.println("");
		}
	}
}