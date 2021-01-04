package exam;

import exam.Command.AddCommand;
import exam.Command.DeleteCommand;
import exam.Command.ModifyCommand;
import exam.Command.SelectCommand;
import exam.Operation.*;

import java.util.Scanner;

public class PersonalMessage {
    private static String admin;

    PersonalMessage(String ADMIN) {
        admin = ADMIN;
        System.out.println(admin + ",欢迎进入出租房客个人信息系统！");
        show();
    }

    public void show() {
        System.out.println("\n1.查询出租房客个人信息\n2.修改出租房客个人信息\n3.删除出租房客个人信息\n4.增加新的房客信息\n5.返回\n");
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
                String sno = scanner.nextLine();
                System.out.print("请输入修改后的住客房号：");
                String hno = scanner.nextLine();
                System.out.print("请输入修改后的住客住房日期：");
                String date = scanner.nextLine();
                System.out.print("请输入修改后的住客姓名：");
                String name = scanner.nextLine();
                System.out.print("请输入住客性别：");
                String sex = scanner.nextLine();
                System.out.print("请输入住客联系电话：");
                String tele = scanner.nextLine();
                System.out.print("请输入修改后的住客押金：");
                String cost = scanner.nextLine();
                System.out.print("请输入修改后的住客房型：");
                String hourse = scanner.nextLine();
                printStar();
                modify(sno, hno, date, name, sex, tele, cost, hourse);
                printStar();
                show();
                break;
            }//改
            case 3: {
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入你要删除的入住编号：");
                String sno = scanner.nextLine();
                printStar();
                delete(sno);
                printStar();
                show();
                break;
            }//删
            case 4: {
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入住客编号：");
                String sno = scanner.nextLine();
                System.out.print("请输入住客房号：");
                String hno = scanner.nextLine();
                System.out.print("请输入住客住房日期：");
                String date = scanner.nextLine();
                System.out.print("请输入住客姓名：");
                String name = scanner.nextLine();
                System.out.print("请输入住客性别：");
                String sex = scanner.nextLine();
                System.out.print("请输入住客联系电话：");
                String tele = scanner.nextLine();
                System.out.print("请输入住客押金：");
                String cost = scanner.nextLine();
                System.out.print("请输入住客房型：");
                String hourse = scanner.nextLine();
                printStar();
                add(sno, hno, date, name, sex, tele, cost, hourse);
                printStar();
                show();
                break;
            }//增
            case 5: {
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

    private void delete(String sno) {
        Opera_Message opera = new Opera_Message(sno);
        DeleteCommand delete = new DeleteCommand(opera);
        Server server = new Server(delete);
        server.execute_message();
    }

    private void modify(String sno, String hno, String date, String name, String sex, String tele, String cost, String hourse) {
        Opera_Message opera = new Opera_Message(sno, hno, date, name, sex, tele, cost, hourse);
        ModifyCommand modify = new ModifyCommand(opera);
        Server server = new Server(modify);
        server.execute_message();
    }

    private void add(String sno, String hno, String date, String name, String sex, String tele, String cost, String hourse) {
        Opera_Message opera = new Opera_Message(sno, hno, date, name, sex, tele, cost, hourse);
        AddCommand add = new AddCommand(opera);
        Server server = new Server(add);
        server.execute_message();
    }

    private void select() {
        Opera_Message opera = new Opera_Message();
        SelectCommand select = new SelectCommand(opera);
        Server server = new Server(select);
        server.execute_message();
    }

    private static void printStar() {
        for (int i = 0; i < 100; i++) {
            System.out.print("*");
        }
        System.out.println();
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
}
