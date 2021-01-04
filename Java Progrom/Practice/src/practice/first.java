package practice;

import java.util.Scanner;

public class first{
    public static void main (String[] args){//控制台方法将小写字母变成大写字母
        System.out.println("请输入一个小写字母：");
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        while(true){
            char c=str.charAt(0);
            char temp=c;
            if(c>=97 && c<=122){
                c=(char)(c-32);
                System.out.println(str+"的第一个字母是:"+temp+"\n"+temp+"的大写字母为："+c);
                break;
            }
            else{
                System.out.println("请输入正确的英文字母！！！\n请继续输入一个小写的英文字母");
                str=scanner.next();
            }
        }
    }
}
