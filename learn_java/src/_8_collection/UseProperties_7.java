package _8_collection;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 集合/使用Properties
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265119084411136#0
 */
public class UseProperties_7 {
    public static void main(String[] args) {
        String f = "test.properties";
        Properties p = new Properties();
        try {
            p.load(new java.io.FileInputStream(f));
        } catch (IOException e) {
            // nothing
        }
        String filepath = p.getProperty("last_open_file");
        String interval = p.getProperty("auto_save_interval", "120"); // 此配置项不存在的话创建一个默认值
        System.out.println(filepath);
        System.out.println(interval);
        // 在内存中设置property配置项
        p.setProperty("url", "www.baidu.com");
        try {
            // 将property配置项写入文件系统中的配置文件
            p.store(new FileOutputStream(f), "写入配置文件的注释");
        } catch (IOException e) {
            // do something
        }

    }
}
