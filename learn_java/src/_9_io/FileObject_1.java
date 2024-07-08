package _9_io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * IO/File对象
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1298069154955297#0
 */
public class FileObject_1 {
    public static void main(String[] args) throws Exception {
        fileObjectCommonUseCase();
        isFileOrDirectoryExist();
        getFilePrivilegeAndSize();
        // createAndDeleteFiles();
        // createAndDeleteTempFiles();
        iterateThroughFilesAndDirectories();
        makeAndDeleteDir();
    }

    // 文件对象一般用法
    public static void fileObjectCommonUseCase() throws IOException {
        File f = new File("./test1.txt");
        System.out.println(f);
        System.out.println(f.getPath()); // 构造方法传入的路径
        System.out.println(f.getAbsolutePath()); // 绝对路径, 不推荐使用此方法获取绝对路径
        System.out.println(f.getCanonicalPath()); // 规范路径, 应当始终使用此方法获取绝对路径

        System.out.println(File.separator); // 文件路径分隔符, 在不同系统中是不同的
    }

    // File对象也可表示目录, 以下为判断File对象是文件还是目录
    public static void isFileOrDirectoryExist() {
        File f = new File("./test1.txt");
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());
    }

    // 获取对应文件的权限和大小
    public static void getFilePrivilegeAndSize() {
        File f = new File("./test1.txt");
        System.out.println(f.canRead());
        System.out.println(f.canWrite());
        System.out.println(f.canExecute());
        System.out.println(f.length()); // 单位为byte
    }

    // 创建和删除文件
    public static void createAndDeleteFiles() throws IOException, InterruptedException {
        File f = new File("./createdByJava");
        f.createNewFile();
        Thread.sleep(3000);
        f.delete();
    }

    // 创建和删除临时文件
    public static void createAndDeleteTempFiles() throws Exception {
        File f = File.createTempFile("tmp-", ".txt"); // 只需提供文件的前后缀即可
        f.deleteOnExit(); // JVM推出时删除
        System.out.println(f.isFile());
        System.out.println(f.getCanonicalPath());
        Thread.sleep(3000);
    }

    // 遍历文件和目录
    public static void iterateThroughFilesAndDirectories() {
        File f = new File("C:\\Windows");
        File[] fs1 = f.listFiles(); // 列出所有的文件和子目录
        Test1.printFiles(fs1);
        File[] fs2 = f.listFiles(new FilenameFilter() { // 仅列出.exe文件
            public boolean accept(File dir, String name) {
                return name.endsWith(".exe");
            }
        });
        Test1.printFiles(fs2);
    }

    // 创建和删除目录
    public static void makeAndDeleteDir() throws InterruptedException {
        File f = new File("./newDirByJavaCode");
        f.mkdir(); // 创建目录
        Thread.sleep(3000);
        f.delete();
    }
}

class Test1 {
    public static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }
}
