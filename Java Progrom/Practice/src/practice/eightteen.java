package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class eightteen {
    public static void main(String[] args) throws FileNotFoundException {
        //确认写入路径
        String path=System.getProperty("user.dir");
        File file =new File(path+"\\cash\\a.html");
        //写入文件
        PrintWriter input =new PrintWriter(file);
        input.println("455140653@qq.com" +
                "78873310@qq.com" +
                "6776881051@163.com" +
                "wwwdfsajk.15.@2980.com");
        input.close();
        //读文件
        Scanner output =new Scanner(file);
//        while(output.hasNext()){
//            System.out.println(output.nextLine());
//        }
        String reg="[a-zA-z\\.[0-9]]*@[a-zA-z[0-9]]*\\.com";
        output.close();

        //文件字符串截取
//        PrintWriter updata=new PrintWriter(file);
        Scanner open=new Scanner(file);
        String str=open.nextLine();
        StringTokenizer stk=new StringTokenizer(str, reg);
        for (;stk.hasMoreTokens();){
            System.out.println(stk.nextToken());
        }
//        int index =str.indexOf("[a-zA-z\\\\.[0-9]]*@[a-zA-z[0-9]]*\\\\.com");
//        String message=str.substring(index);
//        System.out.println(index);
//        while(index!=-1){
//            System.out.println(message);
//            message=message.substring(index,)
//
//        }
//        updata.close();
        open.close();
    }
}
