package exam;

import exam.Operation.Opera_Log;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Login {
    private final static String path = System.getProperty("user.dir") + "\\src\\exam\\cash\\save\\login.doc";//文件默认路径
    private String accountant;
    private String password;


    Login() {
        printStar();
        System.out.println("欢迎使用出租房客信息管理系统！");
        printStar();
    }

    private boolean flag = true;
    public void login() {
        for (int i = 1; flag; i++) {
            if (i == 1) {
                JOptionPane.showMessageDialog(null,
                        "请输入账号密码。",
                        "提示",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (i > 3) {
                Object[] obj = {"重新登陆", "退出程序"};
                try {
                    String options = (String) JOptionPane.showInputDialog(null,
                            "你已经错误输入" + (i - 1) + "次了，请问你还要继续登陆吗？",
                            "message",
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            obj,
                            "点餐");
                    if (options.equals("重新登陆")) {
                    } else {
                        System.out.println("程序已经退出！");
                        System.exit(0);
                    }
                } catch (Exception e) {
                    System.out.println("程序已经退出！");
                    System.exit(0);
                }
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("账号：");
            setAccountant(scanner.nextLine());
            System.out.print("密码：");
            setPassword(scanner.nextLine());
            Opera_Log log = new Opera_Log(getAccountant(), "尝试登陆");
            log.record();
            flag = check();
        }
    }

    private boolean check() {//密码验证
        ArrayList<String> list = new ArrayList<>();
        try {
            //确认文件存在性
            File file = new File(path);
            if (!file.exists()) {
                FileWriter out = new FileWriter(path);
                BufferedWriter bout = new BufferedWriter(out);
                bout.write("管理员账号：\t");
                bout.write("管理员密码：\t\n");
                bout.write("admin\t123456\n");
                bout.close();
            }

            //读取文件写入集合
            FileReader in = new FileReader(path);
            BufferedReader bin = new BufferedReader(in);
            String str;
            while ((str = bin.readLine()) != null) {
                list.add(str);
            }
            bin.close();

        } catch (FileNotFoundException e) {
            System.out.println("文件未找到");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //字符串截取
        String arr = list.get(1);
        StringTokenizer st = new StringTokenizer(arr, "\t");
        String stAN = st.nextToken();
        String stPW = st.nextToken();

        //密码校验
        if ((getAccountant().equals(stAN)) && (getPassword().equals(stPW))) {
            System.out.println("登陆成功！");
            printStar();
            SystemForm systemForm = new SystemForm(getAccountant());
            systemForm.show();
            return false;
        } else if (getAccountant().equals("") || getPassword().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "账号或密码不能为空！",
                    "提示",
                    JOptionPane.WARNING_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "账号或密码错误，请重新输入！",
                    "提示",
                    JOptionPane.WARNING_MESSAGE);
            Opera_Log log = new Opera_Log(getAccountant(), "该用户登陆失败！");
            log.record();
            return true;
        }
    }

    private String getAccountant() {
        return accountant;
    }

    private void setAccountant(String accountant) {
        this.accountant = accountant;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private String getPassword() {
        return password;
    }

    public static void printStar() {
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
