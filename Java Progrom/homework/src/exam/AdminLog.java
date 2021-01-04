package exam;

import exam.Operation.Opera_Log;
import exam.Command.SelectCommand;

import java.util.Scanner;

public class AdminLog {
    private static String admin;

    AdminLog(String ADMIN) {
        admin = ADMIN;
        System.out.println(admin + ",欢迎进入日志系统！");
        show();
    }

    private void show() {
        System.out.println("请问你是否需要查询操作日志？（Y/N）");
        choice();
        printStar();
    }

    private void choice() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        String get = scanner.nextLine().trim();
        printStar();
        while (flag) {
            if (get.equals("Y") || get.equals("y")) {
                select();
                printStar();
                flag = false;
            } else if (get.equals("n") || get.equals("N")) {
                SystemForm SF = new SystemForm(admin);
                SF.show();
                flag = false;
            } else {
                System.out.print("请按提示正确输入相应的字符进行选择！\n请重新输入选择：");
                get = scanner.nextLine().trim();
                printStar();
            }
        }
        SystemForm SF = new SystemForm(admin);
        SF.show();
    }

    private static void printStar() {
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    private void select() {
        Opera_Log opera = new Opera_Log(admin, "查询");
        SelectCommand select = new SelectCommand(opera);
        Server server = new Server(select);
        server.execute_log();
    }
}
