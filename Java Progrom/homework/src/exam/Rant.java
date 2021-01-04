package exam;

import exam.Command.SelectCommand;
import exam.Operation.*;

import java.util.Scanner;

public class Rant {
    private static String admin;

    Rant(String ADMIN) {
        admin = ADMIN;
        System.out.println(admin + ",欢迎进入房租管理系统！");
        show();
    }

    private void show() {
        System.out.println("\n1.查询收租\n2.返回\n");
        System.out.println("请输入数字选择进入你需要的模块：");
        choice();
        printStar();
    }

    private void choice() {
        int flag = scanf();
        printStar();
        switch (flag) {
            case 1: {
                select();
                printStar();
                show();
                break;
            }//查
            case 2: {
                SystemForm SF = new SystemForm(admin);
                SF.show();
            }//返回
            default: {
                System.out.println("你输入的数字有误，程序退出！");
                System.exit(0);
                printStar();
            }
        }
    }

    private void select() {
        Opera_Rant opera = new Opera_Rant();
        SelectCommand select = new SelectCommand(opera);
        Server server = new Server(select);
        server.execute_rant();
        Opera_Log log = new Opera_Log(admin, "查询收租表");
        log.record();
    }

    private static int scanf() {//控制输入格式
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

    private static void printStar() {
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
