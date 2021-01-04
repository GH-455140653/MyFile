package Algorithm.实验二;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int k;
        int[][] arr = new int[50][50];
        System.out.println("假设参赛选手的人数n(n=2^k),请输入k的值：");
        do {
            Scanner scanner = new Scanner(System.in);
            k = scanner.nextInt();
            if (k != 0) {
                table(k, arr);
                print(k, arr);
            } else {
                System.out.println("请重新输入！");
            }
        } while (k != 0);
    }

    public static void table(int k, int[][] arr) {
        int n = 1;
        for (int i = 1; i <= k; i++) {
            n *= 2;
        }
        for (int i = 1; i <= n; i++) {
            arr[1][i] = i;
        }
        int m = 1;
        for (int s = 1; s <= k; s++) {
            n = n / 2;
            for (int t = 1; t <= n; t++) {
                for (int i = m + 1; i <= 2 * m; i++) {
                    for (int j = m + 1; j <= 2 * m; j++) {
                        arr[i][j + (t - 1) * m * 2] = arr[i - m][j + (t - 1) * m * 2 - m];
                        arr[i][j + (t - 1) * m * 2 - m] = arr[i - m][j + (t - 1) * m * 2];
                    }
                    m *= 2;
                }
            }
        }
    }

    public static void print(int k, int[][] arr) {
        int i, j;
        int num = (int) Math.pow(2, k);
        System.out.println("日程表如下");
        for (i = 1; i < num; i++) {
            for (j = 1; j <= num; j++) {
                System.out.println(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
