package _1_java_start._2_array_operation;

import java.util.Arrays;

/**
 * [Java快速入门/数组操作/遍历数组]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1259542828545952
 */
public class IterateThroughArray_1 {
	public static void main(String[] args) {
		IterateThroughArray_1.forLoopIteration();
		IterateThroughArray_1.forEachLoopIteration();
		IterateThroughArray_1.printArray();
	}
	
	//for循环遍历
	public static void forLoopIteration() {
		int[] num = {1,2,3,4,5};
		for(int i=0;i<num.length;i++) {
			System.out.println(num[i]);
		}
	}
	
	//for each循环遍历
	public static void forEachLoopIteration() {
		int[] num = {1,2,3,4,5};
		for(int numItem:num) {
			System.out.println(numItem);
		}
	}
	
	//打印数组
	public static void printArray() {
		int[] num = {1,2,3,4,5};
		System.out.println(Arrays.toString(num));
	}
}
