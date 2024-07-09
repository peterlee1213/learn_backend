package _5_reflection;

/**
 * [反射/Class类]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1264799402020448#0
 */
public class Class_1 {
	public static void main(String[] args) throws ClassNotFoundException {
		String s = "abc";
		
		//可直接从对应类中获取Class实例
		java.lang.Class<String> cls = String.class;
		//可从实例中获取其类对应的Class实例
		java.lang.Class<? extends String> sClass = s.getClass();
		//可从完整类名通过Class静态方法获取其对应的Class实例
		java.lang.Class<?> cls1 = java.lang.Class.forName("java.lang.String");
		System.out.println("");
		Class_1.printClassInfo(cls);
		
	}
	
	public static void printClassInfo(java.lang.Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}
