package practice;

import java.util.Scanner;

public class five {
    //成绩输入返回结果评定
    public static void main(String[] args) {
        Scanner student = new Scanner(System.in);
        boolean bool = false;
        while (true) {
            System.out.print("请输入这位同学的成绩：");
            String str = student.next();
            int grade = Integer.parseInt(str);
            if (grade >= 0 && grade <= 100) {
                bool = true;
                switch (grade / 10) {
                    case 10:
                    case 9:
                        System.out.println("very good!!!");
                        break;
                    case 8:
                        System.out.println("good!!");
                        break;
                    case 7:
                    case 6:
                        System.out.println("pass!");
                        break;
                    default:
                        System.out.println("fail!!!");
                }
            } else {
                System.out.println("请正确输入你的成绩！！！");
            }
            if (bool) break;
        }
    }
}
