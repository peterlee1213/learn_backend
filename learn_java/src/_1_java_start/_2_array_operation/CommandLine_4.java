package _1_java_start._2_array_operation;

public class CommandLine_4 {
	//这个args[]就是运行此java文件时从命令行接收到的参数列表
	public static void main(String[] args) {
		for(String arg:args) {
			if("-version".equals(arg)) {
				System.out.println("v1.0");
			}
		}
	}
}
