package practice;

import java.util.Scanner;
public class four {
    public static void main(String [] args){
//        int num=3;
//        int sum=0;
//        for (int i=0;i<3;i++)
//        {
//            System.out.println(num);
//            num=10*num+3;
//            sum=sum+num;
//        }

//        int[] a ={1,2,3,4,5};
//        for(int i:a)//新方法
//        {
//            System.out.print(i+" ");
//        }

//        for(int i=0;i<a.length;i++)//传统遍历
//        {
//            System.out.print(a[i]+" ");
//        }

//        System.out.println(sum);
        char a ='你';
        char b ='是';
        char c ='傻';
        char d ='毕';
        char e ='吗';
        int secert=121;
        char f=(char) (a&secert);
        char g=(char) (b|secert);
        char h=(char) (c^secert);
        char i=(char) (d|secert);
        char j=(char) (e&secert);
        System.out.println("乱码输出为："+f+g+h+i+j+"\n输入任意字符继续");
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        System.out.print("原文输出为："+a+b+c+d+e);
    }
}
