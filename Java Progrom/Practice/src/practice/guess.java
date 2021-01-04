package practice;

import java.util.Scanner;

public class guess {
    public static void main(String[] args) {
        System.out.print("请输入你要随机数的起始位置：");
        int min = scanf();
        System.out.print("请输入你要随机数的末尾位置：");
        int max = scanf();
        int secert = (int) Math.round(Math.random() * (max - min ) + min);
        System.out.println(secert);
        isGuess(secert);
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

    public static void isGuess(int secert) {
        boolean flag = true;
        int num = 0;
        System.out.print("请输入你猜的数字：");
        int number = scanf();
        while (flag) {
            if (secert == number) {
                num++;
                System.out.printf("恭喜你，猜对了！！！\n你一共用了%d次机会。\n", num);
                break;
            } else if (number > secert) {
                num++;
                System.out.print("大了大了！\n请重新输入：");
                number = scanf();
            } else {
                num++;
                System.out.print("小了小了！\n请重新输入：");
                number = scanf();
            }
        }
    }
}
