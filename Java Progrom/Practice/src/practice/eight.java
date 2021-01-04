package practice;

import java.util.Scanner;

public class eight {//矩阵的输入和输出

    public static void main(String[] args) {
//        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        for (int[] i : a)
//            for (int j : i) {
//                System.out.print(j + " ");
//                if (j % 3 == 0) System.out.print("\n");
//            }

        int[] arr = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }
        for (int i : arr) System.out.println(i);
    }
}
