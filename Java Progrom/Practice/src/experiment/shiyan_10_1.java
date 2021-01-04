package experiment;

import java.io.*;
import java.util.Scanner;

public class shiyan_10_1 {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");//获取当前项目路径
        File file_1 = new File(path + "//cash//1.txt");//路径1.txt
        inputSourse(file_1);
        File file_2 = new File(path + "//cash//2.txt");//路径2.txt
        handle(file_1, file_2);
    }

    public static void handle(File file, File file_2) throws IOException {
        Scanner output_1 = new Scanner(file);
        while (output_1.hasNext()) {
            String message = output_1.nextLine();//获取文本每行信息
            System.out.println(message);//控制台打印每行信息

            int index = message.indexOf(" ");//获取分隔符地址
            String No = message.substring(0, index);//获取信息学号
            String Name = message.substring(index + 1, message.length());//获取信息姓名
            File create = new File(System.getProperty("user.dir") + "//cash//作业收集", "学号" + No + "姓名" + Name);//存储文件的路径
            if (!create.exists()) {
                create.mkdirs();//判断目录是否存在，不存在新建一个为存储文件目录，否则不建
            }
            PrintWriter input = new PrintWriter(create + "\\2.txt");//存储文件下的文件路径
            Scanner output = new Scanner(file_2);
            while (output.hasNext()) {
                String str = output.nextLine();
                input.println(str);
            }
            input.close();
            output.close();
        }
        output_1.close();
    }

    public static void inputSourse(File file) throws FileNotFoundException {
        String sourse = "131501140102 倪景悦\n" +
                "131501140103 李岐\n" +
                "131501140104 韩瑞\n" +
                "131501140105 胡陈扬\n" +
                "131501140106 刘明美\n" +
                "131501140107 谢中于\n" +
                "131501140108 储银根\n" +
                "131501140109 汪兵强\n" +
                "131501140112 成亚峰\n" +
                "131501140114 李俊沨\n" +
                "131501140115 蔺鑫\n";
        PrintWriter input = new PrintWriter(file);
        input.println(sourse);
        input.close();
    }
}
