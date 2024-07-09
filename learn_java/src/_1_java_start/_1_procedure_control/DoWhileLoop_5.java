package _1_java_start._1_procedure_control;

/**
 * [Java快速入门/流程控制/do while循环]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1259541649945472
 */
public class DoWhileLoop_5 {
	public static void main(String[] args) {
		DoWhileLoop_5.commonUseCase();
	}
	
	//一般用法
	public static void commonUseCase() {
		int n = 1;
		int sum = 0;
		
		do {
			sum += n;
			n++;
		}while(n<=100);
		
		System.out.println(sum);
	}
}
