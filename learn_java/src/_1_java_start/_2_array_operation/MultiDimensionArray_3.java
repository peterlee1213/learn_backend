package _1_java_start._2_array_operation;

/**
 * [Java快速入门/数组操作/多维数组]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1259544232593792
 */
public class MultiDimensionArray_3 {
	public static void main(String[] args) {
		MultiDimensionArray_3.commonUseCase();
	}

	// 多维数组的定义和访问
	public static void commonUseCase() {
		int[][] ns = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
		System.out.println(ns[2][2]);
	}
}
