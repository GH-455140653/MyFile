package Algorithm.数字三角形;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class triangle {
    static String path = System.getProperty("user.dir") + "\\cash";//设置文件存储路径

    public static void main(String[] args) {
        System.out.println("请问你的三角形有多少行(1-100)：");
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int[][] arr = new int[rows][rows];
        fileInput(arr);
        handle(arr);
    }

    public static void fileInput(int[][] arr) {
        try {
            //随机数写入文件input.txt和给传递数组赋值
            FileWriter in = new FileWriter(path + "\\input.txt");
            BufferedWriter bin = new BufferedWriter(in);
            bin.write("生成随机数三角形有：" + arr.length + "行。\n");
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j <= i; j++) {
                    int temp = (int) (Math.random() * 10);
                    arr[i][j] = temp;
                    bin.write(temp + " ");
                }
                bin.write("\n");
            }
            bin.close();
        } catch (Exception e) {
            System.out.println("随机数文件生成失败！");
        }
    }

    public static void handle(int[][] arr) {
        int max = 0;//获取求和数组temp每行最大值
        int[][] temp = new int[arr.length][arr.length];//存储每行上下位置相加的数
        ArrayList<Integer> list = new ArrayList<>();//记录路径
        temp[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {//行
            for (int j = 0; j <= i; j++) {//项
                if (j == 0)//左侧相加赋值给temp[i][j]
                    temp[i][j] = temp[i - 1][j] + arr[i][j];
                else if (j == i)//右侧相加后赋值给temp[i][j]
                    temp[i][j] = temp[i - 1][j - 1] + arr[i][j];
                else//中间的数存在多条路径，需要用max函数动态选择出经过这条路的最长路径
                    temp[i][j] = Math.max(temp[i - 1][j - 1], temp[i - 1][j]) + arr[i][j];
            }
        }

        //遍历求和数组的最后一行，找出最大值
        max = temp[arr.length - 1][0];
        for (int i = 0; i < temp[arr.length - 1].length; i++) {
            if (temp[arr.length - 1][i] > max)
                max = temp[arr.length - 1][i];
        }

        getPath(arr, list);//获取路径
        fileOutPut(max, list);//将路径和最大值写入文件
        System.out.println("该路径最大值为：" + max);
    }

    public static void getPath(int[][] arr, ArrayList<Integer> list) {
        int head = 1, tail = 0;
        list.add(arr[0][0]);//首个写入集合
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (head == i && tail == j) {
                    //动态获取最大值写入集合
                    list.add(Math.max(arr[i][j], arr[i][j + 1]));
                    if (arr[i][j] > arr[i][j + 1]) {
                        //直下移
                        head = i + 1;
                    } else {
                        //右下移
                        head = i + 1;
                        tail = j + 1;
                    }
                }
            }
        }
    }

    public static void fileOutPut(int num, ArrayList<Integer> list) {
        try {
            //随机三角形输出
            FileReader out = new FileReader(path + "\\input.txt");
            BufferedReader bout = new BufferedReader(out);
            String temp;
            while ((temp = bout.readLine()) != null) {
                System.out.println(temp);
            }
            bout.close();

            //记录最路径以及该路径的最优解
            FileWriter in = new FileWriter(path + "\\output.txt");
            BufferedWriter bin = new BufferedWriter(in);
            bin.write("最优解结果是：" + num);
            bin.write("\n该最大值的路径为：\n<-");
            for (Integer integer : list) {
                bin.write(integer + "->");
            }
            bin.close();
        } catch (Exception e) {
            System.out.println("文件写入失败！");
        }
    }
}