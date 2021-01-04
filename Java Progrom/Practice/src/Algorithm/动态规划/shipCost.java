package Algorithm.动态规划;

import java.util.Scanner;

public class shipCost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入有几个收费站：");
        int num = scanner.nextInt();
        int[][] cost = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = i+1; j < num; j++) {
                cost[i][j] = scanner.nextInt();
            }
            System.out.println();
        }
    }

    public void cost() {

    }
}
