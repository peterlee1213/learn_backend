package _2_java_object._2_core_class;

import java.math.BigDecimal;

public class BigDecimal_6 {
    public static void main(String[] args) {
        // 可表示任意大小的浮点数，且计算完全准确，常用于财务计算，只能使用实例提供的方法进行运算
        BigDecimal bd = new BigDecimal("123.456");

        System.out.println(bd.multiply(bd));
    }
}
