package experiment;

import java.io.*;

public class shiyan_11_1 {
    public static String pathBMP = "";//定义全局变量获取指定文件的绝对路径

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "\\cash";//获取文件写入目录
        FileOutputStream out = new FileOutputStream(path + "\\1.BMP");//指定写入文件
        BufferedOutputStream bout = new BufferedOutputStream(out);
        File file = new File("D:");//需要查找的磁盘
        TraverDisk(file);
        FileInputStream in = new FileInputStream(pathBMP);
        BufferedInputStream bin = new BufferedInputStream(in);
        int temp;
        while ((temp = bin.read()) != -1) {//字节流写入
            bout.write(temp);
        }
        bin.close();
        bout.close();
    }

    private static void TraverDisk(File i) {//递归调用查找磁盘指定内容
        if (i.listFiles() == null) {//无文件则返回
            return;
        }
        File[] fileArray = i.listFiles();
        for (File file : fileArray) {
            if (file.isDirectory()) {//是目录继续递归
                TraverDisk(file);
            } else {
                if (file.getName().endsWith(".BMP")) {//判断是不是BMP文件
                    pathBMP = file.getAbsolutePath();
                }
            }
        }
    }
}
