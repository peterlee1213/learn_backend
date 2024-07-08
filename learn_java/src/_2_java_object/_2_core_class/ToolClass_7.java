package _2_java_object._2_core_class;

import java.security.SecureRandom;
import java.util.Random;

/**
 * [面向对象编程/Java核心类/常用工具类]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1260473555087392
 */
public class ToolClass_7 {
    public static void main(String[] args) {
        // Math
        System.out.println(Math.abs(-100));
        System.out.println(Math.max(100, 5));
        System.out.println(Math.min(12, 13));
        System.out.println(Math.pow(2, 10)); // 2^10
        System.out.println(Math.sqrt(2));// 根号2
        System.out.println(Math.exp(2));// e^2
        System.out.println(Math.random()); // 生成一个随机数 [0,1)

        // Random 伪随机数，默认以当前系统时间戳作为种子。应该尽量使用SecureRandom
        Random r = new Random();
        System.out.println(r.nextInt()); // 随即生成整数，每次都不一样
        System.out.println(r.nextInt(10)); // [0,10)的整数
        System.out.println(r.nextDouble()); // [0,1)的随机double

        // SecureRandom 真随机数，这是绝对安全不可预测的
        SecureRandom s = new SecureRandom();
        System.out.println(s.nextInt());
        System.out.println(s.nextDouble());
    }
}
