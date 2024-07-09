package _9_io;

import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStream;

/**
 * IO/OutputStream
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1298069169635361#0
 */
public class OutputStream_3 {
    public static void main(String[] args) throws Exception {
        writeByteToFileExample();
        Thread.sleep(3000);
        writeByteArrayToFile();
    }

    // 将若干字节(覆盖)写入文件
    public static void writeByteToFileExample() throws IOException {
        OutputStream o = new FileOutputStream("outstream.txt");
        o.write(72);
        o.write(101);
        o.write(108);
        o.write(108);
        o.write(111);
        o.flush();
        o.close();
    }

    // 一次(覆盖)写入一个byte[]到文件
    public static void writeByteArrayToFile() throws IOException {
        try (OutputStream o = new FileOutputStream("outstream.txt");) {
            o.write("what's your name you lucky fuck".getBytes());
            o.flush();
        }
    }
}
