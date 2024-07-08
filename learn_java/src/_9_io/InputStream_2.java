package _9_io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * IO/InputStream
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1298069163343905#0
 */
public class InputStream_2 {
    public static void main(String... args) throws Exception {
        readFileAndOutput();
        useTryCatchReadFile();
        useTryGrammerInJava7();
        readMultipleBytesAtOneTake();
    }

    // 从一个文件读取所有字节并输出出来
    public static void readFileAndOutput() throws Exception {
        InputStream input = new FileInputStream("test1.txt");
        for (;;) {
            int n = input.read(); // read方法返回一个字节的int值(0-255)
            if (n == -1)
                break;
            System.out.println(n);
        }
        input.close(); // 关闭流,不写的话可能会造成数据丢失内存泄漏等各种意外情况,任何时候都应该写这句话
    }

    // 读取过程中发生IO错误就无法正确的关闭流,因此应该用try-catch-finally来保证IO流被关闭
    public static void useTryCatchReadFile() throws IOException {
        InputStream input = null;
        try {
            input = new FileInputStream("test1.txt");
        } finally {
            if (input != null) {
                input.close();
            }

        }
    }

    // 最理想的做法是用Java 7引入的try(resource)语法, 编译器会自动在try代码块完成后为我们关闭资源
    public static void useTryGrammerInJava7() throws IOException {
        try (InputStream input = new FileInputStream("test1.txt")) {
            while (true) {
                int n = input.read();
                if (n == -1) {
                    break;
                }
                System.out.println(n);
            }
        }
    }

    // 一次性读取多个字节到缓冲区
    public static void readMultipleBytesAtOneTake() throws IOException {
        try (InputStream input = new FileInputStream("test1.txt")) {
            byte[] buffer = new byte[1000]; // 1000byte的缓冲区,即每次可读取1000byte
            while (true) {
                int n = input.read(buffer);
                if (n == -1) {
                    break;
                }
                System.out.println(buffer);
            }
        }
    }
}
