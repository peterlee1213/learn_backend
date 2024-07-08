package _1_java_start._1_procedure_control;

/**
 * [Java快速入门/流程控制/while循环]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1259539701691232
 */
public class WhileLoop_4 {
	public static void main(String[] args) {
		WhileLoop_4.commonUseCase();
	}

	// 一般用法
	public static void commonUseCase() {
		int n = 1;
		int sum = 0;
		while (n <= 100) {
			sum += n;
			n++;
		}
		
		System.out.println(sum);
	}
}
