package Algorithm.贪心算法;

import java.util.Scanner;

/*
导弹拦截问题
 */
public class InterceptMissile {
    public static void main(String[] args) {
        //将输入的导弹写入数组
        System.out.println("请输入各个导弹的高度（写在一行，用空格隔开）：");
        Scanner str = new Scanner(System.in);
        String s = str.nextLine();
        String[] ss = s.split(" ");
        int n = ss.length;
        int[] missile = new int[n];//导弹高度数组
        for (int i = 0; i < missile.length; i++) {
            missile[i] = Integer.parseInt(ss[i]);
        }

        int num = 0;//一套多少个
        int count = 0;//需要多少套
        int[] arr_1 = new int[n];//
        int[] arr_2 = new int[n];//
        for (int i = 0; i < n; i++) {
            arr_1[i] = 1;
            arr_2[i] = 1;
            for (int j = 0; j < i; j++) {
                if (missile[j] > missile[i]) {
                    arr_1[i] = Math.max(arr_1[i], arr_1[j] + 1);
                } else {
                    arr_2[i] = Math.max(arr_2[i], arr_2[j] + 1);
                }
            }
            num = Math.max(num, arr_1[i]);//通过每次结束与之前比较，取出一套系统中最大的导弹数
            count = Math.max(count, arr_2[i]);//通过每次与之前最大值比较，取出全部导弹打完需要多少套
        }
        //输出
        System.out.println("该套系统最多能拦截的导弹数：" + num);
        System.out.println("所有导弹打完最少要配备" + count + "套该系统");
    }
}
