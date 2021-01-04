package exam;

import exam.Operation.Opera_Log;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Password {
    private static final String admin = SystemForm.ADMIN;
    private final static String path = System.getProperty("user.dir") + "\\src\\exam\\cash\\save\\login.doc";//文件默认路径

    Password() {
        System.out.println(admin + ",欢迎进入修改密码系统！");
        show();
    }

    private void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请问你要修改密码吗？（Y/N）");
        String s = scanner.nextLine().trim();
        printStar();
        boolean flag = true;
        while (flag) {
            if (s.equals("y") || s.equals("Y")) {
                flag = false;
                modify();
            } else if (s.equals("n") || s.equals("N")) {
                flag = false;
                SystemForm SF = new SystemForm(admin);
                SF.show();
            } else {
                System.out.print("请正确选择并输入相应的字符！\n请问你要修改密码吗？（Y/N）");
                s = scanner.nextLine().trim();
                printStar();
            }
        }
    }

    private void modify() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你要修改的密码：");
        String password = scanner.nextLine().trim();
        System.out.print("请再次输入确认你的密码：");
        String pwd_sure = scanner.nextLine().trim();
        printStar();

        boolean flag = true;
        while (flag) {
            if (password.equals("") || pwd_sure.equals("")) {
                System.out.println("两个密码输入有空值！请重新输入！");
                System.out.print("请输入你要修改的密码：");
                password = scanner.nextLine().trim();
                System.out.print("请再次输入确认你的密码：");
                pwd_sure = scanner.nextLine().trim();
                printStar();
            } else if (!password.equals(pwd_sure)) {
                System.out.println("两次输入密码不一样！请重新输入!");
                System.out.print("请输入你要修改的密码：");
                password = scanner.nextLine().trim();
                System.out.print("请再次输入确认你的密码：");
                pwd_sure = scanner.nextLine().trim();
                printStar();
            } else {
                try {
                    FileReader in = new FileReader(path);
                    BufferedReader bin = new BufferedReader(in);
                    ArrayList<String> list = new ArrayList<>();

                    String temp;
                    while ((temp = bin.readLine()) != null) {
                        list.add(temp);
                    }
                    bin.close();

                    FileWriter out = new FileWriter(path);
                    BufferedWriter bout = new BufferedWriter(out);
                    bout.write(list.get(0) + "\n");
                    bout.write(admin + "\t" + password + "\n");

                    bout.close();

                    Opera_Log log = new Opera_Log(admin, "修改了密码");
                    log.record();

                    JOptionPane.showMessageDialog(null,
                            "密码修改成功！请重新登陆！",
                            "提示",
                            JOptionPane.INFORMATION_MESSAGE);
                    flag = false;
                    Login login = new Login();
                    login.login();
                } catch (FileNotFoundException e) {
                    System.out.println("文件路径有问题。");
                } catch (IOException e) {
                    System.out.println("文件读取失败。");
                }
            }
        }
    }

    public static void printStar() {
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
