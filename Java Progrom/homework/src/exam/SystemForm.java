package exam;

import exam.Operation.Opera_Log;

import java.util.Scanner;

public class SystemForm {
    public static String ADMIN;

    SystemForm(String admin) {
        ADMIN = admin;
        System.out.println(ADMIN + "，欢迎回来！\n");
        Opera_Log log = new Opera_Log(ADMIN, "进入了操作系统");
        log.record();
    }

    public void show() {
        System.out.println("1.租客个人信息系统\n2.资源消耗管理系统\n3.房租管理系统\n4.修改密码\n5.操作日志\n6.退出程序\n");
        System.out.println("请输入数字选择进入你需要的模块：");
        choice();
        printStar();
    }

    private void choice() {
        int flag = scanf();
        printStar();
        switch (flag) {
            case 1: {
                PersonalMessage PM = new PersonalMessage(ADMIN);
                break;
            }
            case 2: {
                Resource resourse = new Resource(ADMIN);
                break;
            }
            case 3: {
                Rant rant = new Rant(ADMIN);
                break;
            }
            case 4: {
                Password password = new Password();
                break;
            }

            case 5: {
                AdminLog adminLog = new AdminLog(ADMIN);
                break;
            }
            case 6: {
                System.out.println("程序已退出！");
                System.exit(0);
                printStar();
            }
            default: {
                System.out.println("你输入的数字有误，程序退出！");
                System.exit(0);
                printStar();
            }
        }
    }

        private static int scanf () {//控制输入格式
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

        public static void printStar () {
            for (int i = 0; i < 50; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
}

