package practice;

import java.util.Arrays;
import java.util.Scanner;

public class nine {
    //评委打分，去除最高最低取均值
    public static void main(String[] args) {
        thePoint();
    }

    public static void thePoint() {
        numJudges();//获取评委数
    }

    public static void numJudges() {
        System.out.print("请输入评委数：");
        int num = scanf();
        pointList(num);//获取评委分数
    }

    public static void pointList(int num) {
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("请输入第%d位评委的分数：", i + 1);
            arr[i] = scanf();
        }
        listHandle(arr);//数组处理
    }

    public static void listHandle(int[] arr) {
        Arrays.sort(arr);
        int[] array = new int[arr.length - 2];
        for (int i = 1; i < arr.length - 1; i++) {
            array[i - 1] = arr[i];
        }
        System.out.println("去除最高分和最低分后的分数有：");
        for (int i : array) System.out.print(" " + i);
        dataHandle(array);//数据处理
    }

    public static void dataHandle(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum = sum + value;
        }
        double avepoint = sum / (double) arr.length;
        System.out.println("\n这位同学的分数为：" + avepoint);//输出结果
    }

    public static int scanf() {
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            num = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("请输入数字！！！");
            System.exit(0);
        }
        return num;
    }
}
