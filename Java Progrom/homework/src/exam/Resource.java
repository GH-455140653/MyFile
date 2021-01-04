package exam;

import exam.Command.AddCommand;
import exam.Command.DeleteCommand;
import exam.Command.ModifyCommand;
import exam.Command.SelectCommand;
import exam.Operation.*;

import java.util.Scanner;

public class Resource {
    private static String admin;

    Resource(String ADMIN) {
        admin = ADMIN;
        System.out.println(admin + ",欢迎进入出租房客资源管理系统！");
        show();
    }

    private void show() {
        System.out.println("\n1.查询房客资源消耗情况\n2.修改房客资源消耗情况\n3.删除房客资源消耗情况\n4.增加房客资源消耗情况\n5.返回\n");
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
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入你要修改的入住编号：");
                String no = scanner.nextLine();
                System.out.print("请输入修改后的水费：");
                String cost_w = scanner.nextLine();
                System.out.print("请输入修改后的电费：");
                String cost_e = scanner.nextLine();
                System.out.print("请输入修改后的房租费用：");
                String cost = scanner.nextLine();
                printStar();
                modify(no, cost_w, cost_e, cost);
                printStar();
                show();
                break;
            }//改
            case 3: {
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入你要删除的入住编号：");
                String no = scanner.nextLine();
                printStar();
                delete(no);
                printStar();
                show();
                break;
            }//删
            case 4: {
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入住客入住编号：");
                String no = scanner.nextLine();
                System.out.print("请输入该住客用水费用：");
                String cost_w = scanner.nextLine();
                System.out.print("请输入该住客用电费用：");
                String cost_e = scanner.nextLine();
                System.out.print("请输入该住客的房租费用：");
                String cost = scanner.nextLine();
                printStar();
                add(no, cost_w, cost_e, cost);
                printStar();
                show();
                break;
            }//增
            case 5: {
                SystemForm SF = new SystemForm(admin);
                SF.show();
            }//返回
        }
    }

    private void add(String no, String cost_W, String cost_E, String cost) {
        Opera_Resource opera = new Opera_Resource(no, cost_W, cost_E, cost);
        AddCommand add = new AddCommand(opera);
        Server server = new Server(add);
        server.execute_resourse();
    }

    private void delete(String no) {
        Opera_Resource opera = new Opera_Resource(no);
        DeleteCommand delete = new DeleteCommand(opera);
        Server server = new Server(delete);
        server.execute_resourse();
    }

    private void modify(String no, String cost_w, String cost_e, String cost) {
        Opera_Resource opera = new Opera_Resource(no, cost_w, cost_e, cost);
        ModifyCommand modify = new ModifyCommand(opera);
        Server server = new Server(modify);
        server.execute_resourse();
    }

    private void select() {
        Opera_Resource opera = new Opera_Resource();
        SelectCommand select = new SelectCommand(opera);
        Server server = new Server(select);
        server.execute_resourse();
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
