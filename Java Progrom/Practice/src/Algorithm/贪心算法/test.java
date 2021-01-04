package Algorithm.贪心算法;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int num = 0;
        int count = 0;
        System.out.println("请问有几个导弹：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] missile = new int[n];
        for (int i = 0; i < n; i++) {
            missile[i] = (int) (Math.random() * 100);
        }
//        for (int i : missile) {
//            System.out.print(i+" ");
//        }
        ArrayList<int[]> list = new ArrayList<>();
        int[] arr_1 = new int[n];
        int[] arr_2 = new int[n];
        for (int i = 0; i < missile.length; i++) {
            if (i == 0) {
                arr_1[i] = missile[i];
            }
            for (int j = 0; j < i; j++) {
                if (missile[j] > missile[i]) {
//                    arr_1[]
                }
            }

        }
    }
}
