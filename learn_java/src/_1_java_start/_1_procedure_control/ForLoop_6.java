package _1_java_start._1_procedure_control;

/**
 * [Java快速入门/流程控制/for循环]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1259540152578912
 */
public class ForLoop_6 {
	public static void main(String[] args) {
		ForLoop_6.commonUseCase();
		ForLoop_6.forEachLoop();
	}
	
	//一般用法
	public static void commonUseCase() {
		int sum = 0;
		for(int i=1; i<=100; i++) {
			sum += i;
		}
		
		System.out.println(sum);
	}
	
	//for each遍历数组
	public static void forEachLoop() {
		int[] numArr = {1,2,3,4,5};
		int sum = 0;
		for(int i=0; i<numArr.length; i++) {
			sum += numArr[i];
		}
		
		System.out.println(sum);
	}
}
