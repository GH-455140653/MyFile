package experiment;

import java.util.Scanner;
import java.util.StringTokenizer;

public class shiyan_9_2 {
    public static void main(String[] args) {
        boolean flag = true;
        System.out.println("请输入国家的名称：");
        StringBuffer strName = new StringBuffer();
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            if (name.equals("#")) flag = false;
            else {
                strName.append(name);
                strName.append("@");
            }
        }
        String str = new String(strName);
        StringTokenizer sstr = new StringTokenizer(str, "@");
        while(sstr.hasMoreTokens()){
            System.out.println(sstr.nextToken().toUpperCase());
        }
    }
}
