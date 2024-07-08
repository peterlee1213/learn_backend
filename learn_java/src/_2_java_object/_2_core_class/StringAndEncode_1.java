package _2_java_object._2_core_class;

import java.util.Arrays;

/**
 * [面向对象编程/Java核心类/字符串和编码]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1260469698963456
 */
public class StringAndEncode_1 {
    public static void main(String[] args) {
        StringAndEncode_1.stringCompareCase();
        StringAndEncode_1.otherStringMethods();
    }

    // 字符串比较应当总是使用equal
    public static void stringCompareCase() {
        Test1 t = new Test1();
        System.out.println(t.s1 == t.s2);
        System.out.println(t.s1.equals(t.s2));
    }

    // 字符串的其他常用方法
    public static void otherStringMethods() {
        Test2 t = new Test2();

        // 是否包含子串
        System.out.println(t.s1.contains("ll"));

        // 其他搜索子串的例子
        System.out.println(t.s1.indexOf("l"));
        System.out.println(t.s1.lastIndexOf("l"));
        System.out.println(t.s1.startsWith("He"));
        System.out.println(t.s1.endsWith("lo"));

        // 提取子串
        System.out.println(t.s1.substring(2));
        System.out.println(t.s1.substring(2, 4));

        // 移除英文字符串首尾空白字符
        System.out.println(t.enStr.trim());

        // 移除中文英文等各种语言字符串首尾空白字符
        System.out.println(t.enStr.strip());
        System.out.println(t.cnStr.strip());

        // 判断字符串是否为空（长度为0）
        System.out.println("".isEmpty()); // true
        System.out.println("  ".isEmpty()); // false

        // 判断字符串是否之包含空白字符
        System.out.println("   \n".isBlank()); // true
        System.out.println("\u3000  \r\n".isBlank()); // true
        System.out.println("\u3000 hel \r\n".isBlank()); // false

        // 替换子串
        System.out.println(t.s1.replace("l", "we"));

        // 分割字符串
        System.out.println(Arrays.toString("A,B,C,D".split(",")));

        // 拼接字符串
        String[] cStr = new String[] { "a", "b", "c", "e" };
        System.out.println(String.join("%%%%%", cStr));

        // 格式化字符串
        String s = "Hi %s, your score is %d";
        System.out.println(s.formatted("Peter", 80));

        // 其他类型转换为字符串
        System.out.println(String.valueOf(123));
        System.out.println(String.valueOf(45.67));
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf(new Object()));

        // 字符串转换为其他类型
        System.out.println(Integer.parseInt("123"));
        System.out.println(Double.parseDouble("12.345"));
        System.out.println(Boolean.parseBoolean("true"));
        System.out.println(Arrays.toString("hello".toCharArray()));
    }
}

class Test1 {
    String s1 = "hello";
    String s2 = "HELLO".toLowerCase();
}

class Test2 {
    String s1 = "Hello";

    String enStr = "  \tenglish words\r\n   ";
    String cnStr = "\u3000中文字符\u3000";
}