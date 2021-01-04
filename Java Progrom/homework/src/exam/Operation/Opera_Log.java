package exam.Operation;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Opera_Log {
    private final String path = System.getProperty("user.dir") + "\\src\\exam\\cash\\log\\adminOpera.doc";//默认文件存放路径
    private final String admin;
    private final String opera;

    public Opera_Log(String admin, String opera) {
        this.admin = admin;
        this.opera = opera;
    }

    public void select() {
        try {
            fileExists();//判断文件的存在性
            FileReader in = new FileReader(path);
            BufferedReader bin = new BufferedReader(in);
            String str;
            while ((str = bin.readLine()) != null) {
                System.out.println(str);
            }
            bin.close();
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("该路径下文件没找到!");
        } catch (IOException e) {
            System.out.println("文件写入失败!");
        }
    }

    public void record() {
        fileExists();
        ArrayList<String> list = new ArrayList<>();
        read(list);
        write(time(), this.admin, this.opera, list);
    }

    private void read(ArrayList<String> list) {
        try {
            FileReader in = new FileReader(path);
            BufferedReader bin = new BufferedReader(in);
            String temp;
            while ((temp = bin.readLine()) != null) {
                list.add(temp + "\n");
            }
            bin.close();
        } catch (FileNotFoundException e) {
            System.out.println("未找到文件路径！");
        } catch (IOException e) {
            System.out.println("文件读取遇到未知错误！");
        }
    }

    private void write(String date, String name, String opera, ArrayList<String> list) {
        try {
            FileWriter out = new FileWriter(path);
            BufferedWriter bout = new BufferedWriter(out);

            list.add(date + "\t\t");
            list.add(name + "\t\t");
            list.add(opera + "\n");

            for (String value : list) {
                bout.write(value);
            }
            bout.close();

        } catch (IOException e) {
            System.out.println("文件写入失败！");
        }
    }

    private static String time() {
        Date date = new Date();
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    private void fileExists() {
        try {
            File file = new File(path);
            if (!(file.exists())) {//当存储文档不存在时，创建一个
                System.out.println("\n不存在存储管理员操作的文件,系统已经为你自动创建了一个日志文档。\n");
                //写入
                FileWriter out = new FileWriter(path);
                BufferedWriter bout = new BufferedWriter(out);
                bout.write("时间\t\t\t\t\t\t");
                bout.write("管理员\t\t");
                bout.write("操作\n");
                bout.close();//关闭写入
            }
        } catch (IOException e) {
            System.out.println("文件写入失败！");
        }
    }//判断文件存在

}
