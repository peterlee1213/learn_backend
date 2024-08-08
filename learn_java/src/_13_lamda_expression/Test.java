package _13_lamda_expression;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.testLamdaInForEach();
        test.storeLamdaInVariable();

        StringFunction exclaim = (s) -> s + "!";
        test.printFormatted("hello world", exclaim);
    }

    /**
     * 在foreach方法中使用lamda表达式
     */
    public void testLamdaInForEach() {
        System.out.println("在foreach中使用lamda表达式");
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(31);
        list.add(5);
        list.forEach(item -> {
            System.out.println(item);
        });
        System.out.println("==================================");
    }

    /**
     * lamda表达式可以存储为一个变量
     */
    public void storeLamdaInVariable() {
        System.out.println("将lamda表达式存储为变量");
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(31);
        list.add(5);
        Consumer<Integer> method = (item) -> {
            System.out.println(item);
        };
        list.forEach(method);
        System.out.println("==================================");
    }

    /**
     * 使用lamda表达式作为一个参数
     */
    public void printFormatted(String str, StringFunction format) {
        String run = format.run(str);
        System.out.println(run);

    }
}

public interface StringFunction {

    String run(String str);

}
