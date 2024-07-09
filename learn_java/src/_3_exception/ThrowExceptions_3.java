package _3_exception;

/**
 * [异常处理/抛出异常]
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1264738764506656#0
 */
public class ThrowExceptions_3 {
    public static void main(String[] args) {

    }

    // 如何在代码中创建并抛出异常
    public static void throwExceptionsInCode(String s) {
        if (s == null)
            throw new NullPointerException();
    }

    // 重新抛出不同的Exception实例时有的Exception调用堆栈信息会丢失，可将旧的Exception作为参数传入新的Exception中
    public static void nestedException() {
        try {
            // some code
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
