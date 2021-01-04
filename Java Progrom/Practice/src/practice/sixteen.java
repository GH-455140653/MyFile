package practice;

import java.util.Scanner;

public class sixteen {
    public static void main(String[] args) {
//        String message = "My email is dqpilzg@163.com!Y……";
//        int index = message.indexOf("!");//获取！的索引
//        String a = message.substring(0, index);//截取从0开始到索引位置的字符串
//        int b = a.lastIndexOf(" ");//找出最后一个空格的索引
//        String email = a.substring(b + 1, index);//截取从空格后一位字符开始到！的字符串
//        System.out.println(email);

        StringBuffer oldstrbuffer = new StringBuffer("asd");
        StringBuffer reold = oldstrbuffer.reverse();
        String oldstr = new String(reold);
        System.out.println("请输入一串字符串：");
        Scanner scanner = new Scanner(System.in);
        String newstr = scanner.nextLine();
        if (oldstr.equals(newstr))
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
