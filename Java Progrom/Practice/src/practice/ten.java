package practice;

import java.util.Scanner;

public class ten {
    public static void main(String[] args) {
        int n, m;//被乘数与乘数
        int result = 0;//每道题的正确/错误
        double time;//题目数量
        System.out.print("请问你想做几道题：");
        time = scanf();
        for (int i = 0; i < time; i++) {
            n = randomNumber();
            m = randomNumber();
            result = result + resultCollect(n, m);
        }
        rate(result, time);
    }

    public static int resultCollect(int n, int m) {//判断结果
        int time = 1;//控制变量，有错则0。
        System.out.printf("%d乘%d的积是多少？\n", n, m);
        System.out.print("请输入题目结果：");
        int sum = scanf();
        while (true) {
            if (n * m == sum) {
                System.out.println("非常棒！");
                return time;
            } else {
                time = 0;
                System.out.println("不对，请再试一次");
                sum = scanf();
            }
        }
    }

    public static void rate(int result, double time) {//正确率
        double correctRate = result / time;
        if (correctRate > (3 / 4.0)) {
            System.out.printf("你的正确率为：%.2f", correctRate * 100);
            System.out.println("%");
        } else {
            System.out.printf("你的正确率为：%.2f", correctRate * 100);
            System.out.println("%");
            System.out.println("请老师给你辅导一下！");
        }
    }

    public static int randomNumber() {//生成随机数
        return (int) (Math.random() * 11);
    }

    public static int scanf() {//控制输入格式
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
