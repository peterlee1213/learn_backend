package _1_java_start._1_procedure_control;

/**
 * [Java快速入门/流程控制/break和continue]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1259542531392800
 */
public class BreakAndContinue_7 {
	public static void main(String[] args) {
		BreakAndContinue_7.breakUseCase();
		BreakAndContinue_7.continueUseCase();
	}

	// break会终止当前循环，使用方法如下
	public static void breakUseCase() {
		int sum = 0;

		for (int i = 1; i <= 100; i++) {
			if (i == 100) {
				break;
			}
			
			sum += i;
		}
		
		System.out.println(sum);
	}
	
	//continue会跳过当前这一轮循环并进入下一轮，使用方法如下
	public static void continueUseCase() {
		int sum = 0;
		for(int i = 1; i<= 100; i++) {
			if(i%2 == 0) continue;
			sum += i;
		}
		
		System.out.println(sum);
	}
}
