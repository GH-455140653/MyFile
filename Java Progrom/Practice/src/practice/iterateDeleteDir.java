package practice;

import java.io.File;

public class iterateDeleteDir {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "\\cash\\作业收集");//获取要删除的目录
        deleteFileAll(file);
    }

    public static void deleteFileAll(File file) {//递归删除目录下的文件
        if (file.exists()) {
            File files[] = file.listFiles();
            int len = files.length;
            for (int i = 0; i < len; i++) {
                if (files[i].isDirectory()) {
                    deleteFileAll(files[i]);
                } else {
                    files[i].delete();
                }
            }
            file.delete();
        }
    }
}
