package Algorithm.贪心算法;

import java.util.Scanner;

/*
均分纸牌
 */
public class SplitCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, sum = 0, count = 0;
        int average;
        System.out.println("请输入你有多少组纸牌：");
        n = scan.nextInt();//组数
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("第" + (i + 1) + "组纸牌：");
            a[i] = scan.nextInt();
            sum = sum + a[i];//求和
        }
        average = sum / n;//求均值
        for (int i = 0; i < n; i++)
            a[i] = a[i] - average;//求差值
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {//跳过差值为0，不需要移动
                a[i + 1] = a[i + 1] + a[i];//i位牌全部移动给i+1位进行覆盖，求出差值，重新写入
                count++;//次数统计
                a[i] = 0;//i位归0
            }
        }
        System.out.println(count);
    }
}
