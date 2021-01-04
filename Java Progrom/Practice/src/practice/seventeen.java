package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class seventeen {
    public static void main(String[] args) throws FileNotFoundException {
        String path = System.getProperty("user.dir");
        File file = new File(path + "\\cash\\a.txt");
        //读文件
        PrintWriter input = new PrintWriter(file);
        input.println("Zhangsan English 90");
        input.println("Zhangsan Java 85");
        input.println("Lisi English 82");
        input.println("Lisi Java 80");
        input.close();
        //写文件
        Scanner output = new Scanner(file);
        while (output.hasNext()) {//
            String str = output.nextLine();
            System.out.println(str);
        }
    }
}
