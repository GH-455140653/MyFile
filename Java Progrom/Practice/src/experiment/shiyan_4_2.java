package experiment;

import java.util.Scanner;

public class shiyan_4_2 {
    public static void main(String[] args) {
        System.out.println("请输入n的大小：");
        int n = scanf();
        System.out.println(treaver(n));
    }

    public static int treaver(int index) {
        int base=2;
        int sum=0;
        for(int i=0;i<=index;i++){
            sum= (int) (sum+Math.pow(base,i));
        }
        return sum;
    }

    public static int scanf() {
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
