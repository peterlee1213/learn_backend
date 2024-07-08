package _1_java_start._1_procedure_control;

/**
 * [Java快速入门/流程控制/if判断]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1259539352677728
 */
public class If_2 {
	public static void main(String[] args) {
		If_2.commonUseCase();
		If_2.ifDoubleEqual();
		If_2.ifReferenceVarsEqual();
	}
	
	//通用案例
	public static void commonUseCase() {
		int n = 70;
		
		if(n >= 90) {
			System.out.println("优秀");
		}else if(n >= 60) {
			System.out.println("及格");
		} else {
			System.out.println("挂科");
		}
		
		System.out.println("END");
	}
	
	//判断小数是否相等
	public static void ifDoubleEqual() {
		double x = 1-9.0/10;
		
		if(Math.abs(x-0.1)<0.00001) {
			System.out.println("x is 0.1");
		}else {
			System.out.println("x is NOT 0.1");
		}
	}
	
	//判断引用类型的变量内容是否相等必须用equals方法
	public static void ifReferenceVarsEqual() {
		String s1 = "hello";
		String s2 = "HELLO".toLowerCase();
		
		//null对象不具有equals方法，必须排除
		if(s1!= null && s1.equals(s2)) {
			System.out.println("s1 equals s2");
		}else {
			System.out.println("s1 is NOT equal s2");
		}
	}
}
