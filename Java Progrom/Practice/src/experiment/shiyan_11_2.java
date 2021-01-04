package experiment;

import java.io.*;

public class shiyan_11_2 {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "\\cash\\name.txt";//设置文件存储路径
        File file = new File("D:");//设置需要获取的目录
        File[] dirName = file.listFiles();//将目标路径下的目录列表进行获取
        File fileWrite = new File(path);
        FileWriter output = new FileWriter(fileWrite);
        BufferedWriter bWrite = new BufferedWriter(output);
        for (int i = 0; i < dirName.length; i++) {
            if (dirName[i].isDirectory()) {
                String name = dirName[i].getName();
                bWrite.write(name + "\n");
            }
        }
        bWrite.close();
    }
}
