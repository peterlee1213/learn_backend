package _3_exception;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * [异常处理/Java的异常]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1264734349295520#0
 */
public class JavaException_1 {
    // 若是不捕获e.test() throws的Exception, 就得在调用e.test()的函数声明中再次抛出此异常
    public static void main(String[] args) throws Exception {
        // 一般用法
        byte[] bs = toGBK("中文");
        System.out.println(Arrays.toString(bs));

        // 必须要捕获的异常
        ExceptionTest e = new ExceptionTest();
        e.test(); // 报错，unhandled exception，或者也可以不捕获此异常，而是在此函数定义处再将此Exception抛出
    }

    public static byte[] toGBK(String s) {
        try {
            return s.getBytes("GBK");

        } catch (UnsupportedEncodingException e) {
            // 此方法可打印出发生错误时程序执行的堆栈
            e.printStackTrace();
            return s.getBytes(); // 尝试使用用默认编码

        }
    }
}

class ExceptionTest {
    // 定义函数时throws Exception会导致在调用函数时必须捕获此异常，否则编译器会报错
    public void test() throws Exception {

    }
}
