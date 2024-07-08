package _1_java_start._1_procedure_control;

import java.util.Scanner;

/**
 * [Java快速入门/流程控制/输入和输出]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1255887264020640
 */
public class InputAndOutput_1 {
	public static void main(String[] args) {
		InputAndOutput_1.output();
		InputAndOutput_1.input();
	}
	
	public static void output() {
		System.out.println("输出：");
		
		System.out.print("print是没有换行符的");
		
		System.out.println("格式化输出:");
		
		System.out.printf("输出整数:%d",12);
		System.out.printf("输出浮点数:%f",12.3);
		System.out.printf("输出字符串:%s","abc");
	}
	
	public static void input() {
		System.out.println("输入:");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input your name:");
		String name = scanner.nextLine();
		System.out.print("Input your age:");
		int age = scanner.nextInt();
		
		System.out.printf("Hi, %s, you're %d\n",name,age);
	}
}


