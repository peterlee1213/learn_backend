package _2_java_object._2_core_class;

import java.math.BigInteger;

/**
 * [面向对象编程/Java核心类/BigInteger]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1279767986831393#0
 */
public class BigInteger_5 {
    public static void main(String[] args) {
        // BigInteger可进行超过long数值大小的计算
        BigInteger bi = new BigInteger("12537868732674236458723498");
        System.out.println(bi.pow(5));

        // BigInteger进行计算时只能使用实例提供的方法而非+-*/
        System.out.println(bi.add(bi));
    }
}
