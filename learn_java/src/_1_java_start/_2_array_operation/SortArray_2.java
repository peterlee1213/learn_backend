package _1_java_start._2_array_operation;

import java.util.Arrays;

/**
 * [Java快速入门/数组操作/数组排序]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1259543088592672
 */
public class SortArray_2 {
	public static void main(String[] args) {
		SortArray_2.commonUseCase();
	}
	
	//一般排序方法
	public static void commonUseCase() {
		int[] arr = {1,3,2,5,4};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
