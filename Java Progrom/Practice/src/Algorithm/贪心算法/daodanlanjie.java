package Algorithm.贪心算法;

import java.util.Scanner;

public class daodanlanjie {
    public static void main(String[] args) {
        System.out.println("请输入各个导弹的高度（写在一行，用空格隔开）：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] ss = str.split(" ");
        int n = ss.length;
        int[] missile = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            missile[i] = Integer.parseInt(ss[i - 1]);
        }

        int maxMissile = 1;
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) b[i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (missile[i] >= missile[j]) {
                    b[j] = Math.max(b[j], b[i] + 1);
                    maxMissile = Math.max(b[j], maxMissile);
                }
            }
        }
        System.out.println("该套系统最多能拦截的导弹数：" + maxMissile);

        int maxSystem = 0;
        boolean[] c = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int index = -1;
            for (int j = 1; j < i; j++) {
                if (missile[j] >= missile[i] && !c[j]) {
                    index = j;
                }
            }
            if (index == -1) {
                maxSystem++;
            } else {
                for (int j = 1; j < i; j++) {
                    if (j == index) {
                        c[j] = true;
                    }
                }
            }
        }

        System.out.println("所有导弹打完最少要配备" + maxSystem + "套该系统");
    }
}
