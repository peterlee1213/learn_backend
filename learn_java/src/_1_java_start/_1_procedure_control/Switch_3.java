package _1_java_start._1_procedure_control;

/**
 * [Java快速入门/流程控制/switch多重选择]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1259541030848864
 */
public class Switch_3 {
	public static void main(String[] args) {
		Switch_3.commonUseCase();
		Switch_3.newUseCase();
		Switch_3.newGrammerReturnValue();
	}

	// 一般使用方式
	public static void commonUseCase() {
		String fruit = "apple";
		switch (fruit) {
		case "apple": {
			System.out.println("Selected apple");
			break;
		}
		case "banana": {
			System.out.println("Selected banana");
			break;
		}
		default: {
			System.out.println("Nothing selected");
			break;
		}
		}
	}

	// 最新的switch语法(从JAVA12开始), 用不着写break语句
	public static void newUseCase() {
		String fruit = "apple";
		switch (fruit) {
		case "apple" -> {
			System.out.println("apple");
		}
		case "pear" -> {
			System.out.println("pear");
		}
		default -> {
			System.out.println("Nothing selected");
		}
		}
	}

	// 最新switch语法可根据不同case直接返回值
	public static void newGrammerReturnValue() {
		int num1 = 12;
		int num2 = 34;
		String action = "+";

		int result = switch (action) {
		case "+" -> {
			yield (num1 + num2);
		}
		case "-" -> {
			yield (num1 - num2);
		}
		default -> {
			yield 0;
		}
		};

		System.out.println(result);

	}

}
