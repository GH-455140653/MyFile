package Algorithm.实验二;

import java.util.*;

public class BlackAndRed_DFS {
    public static char[][] form = new char[10][10];//定义表格的边界,用于存放红黑格子
    public static int[] dx = {-1, 0, 1, 0};//水平方向的变化范围，左上右下
    public static int[] dy = {0, 1, 0, -1};//竖直方向的变化范围，左上右下
    public static int n, m, x, y;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入绘制表格的宽度：");
        m = scanner.nextInt();
        System.out.println("请输入绘制表格的高度：");
        n = scanner.nextInt();
        System.out.printf("请输入%d行%d列的矩阵，每行结束回车换行：\n", n, m);

        if (n == 0 && m == 0) {//无列无行，退出程序
            return;
        }

        for (int i = 0; i < n; i++) {
            String s = scanner.next();//外界获取第i-1行的结构字符串
            form[i] = s.toCharArray();//将刚输入的字符串转换成字节数组
            for (int j = 0; j < m; j++) {//遍历字节数组，寻找@，@表示自定义起始位置，没有输入默认(0,0)
                if (form[i][j] == '@') {
                    x = i;
                    y = j;
                    form[i][j] = '1';
                }
            }
        }

        dfs(x, y);

        print();//输出黑格子数
    }

    public static void dfs(int x, int y) {//优先级：上右下左
        form[x][y] = '1';//将路过的*变为1
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && form[a][b] == '*') {//*表示黑格子，判断四个方向是否有*以及是否到边界
                dfs(a, b);
            }
        }
    }

    public static void print() {
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (form[i][j] == '1') {
                    num++;//遍历字符数组，找出字符数组中值为1的项，即为黑格子数
                }
            }
        }
        System.out.println("总有" + num + "个黑格子能被路过");
    }
}

//package Algorithm.实验二;
//
//        import java.util.*;
//
//public class BlackAndRed_BFS {
//    static int row, column, count = 0;
//    static String[][] arr;
//    static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};// 方向数组
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int i, j, Px = 0, Py = 0;
//        String str;
//        while (true) {
//            column = scanner.nextInt();//列
//            row = scanner.nextInt();//行
//            if (column == 0 && row == 0) {
//                return;
//            }
//
//            arr = new String[row + 2][column + 2];
//            for (i = 1; i <= row; i++) {
//                str = scanner.next();
//                for (j = 1; j <= column; j++) {
//                    arr[i][j] = str.charAt(j - 1) + "";
//                    if (arr[i][j].equals("@")) {
//                        Px = i;
//                        Py = j;
//                    }
//                }
//            }
//
//            dfs(Px, Py);
//            System.out.println(count);
//            count = 0;
//        }
//    }
//
//    static void dfs(int Px, int Py) {
//        // 判断如果处于边界或者是红砖，则直接返回
//        if (Px < 1 || Px > row || Py < 1 || Py > column || arr[Px][Py].equals("#")) {
//            System.out.println(count);
//        } else {
//            count++;
//            arr[Px][Py] = "#";
//            dfs(Px + dir[0][0], Py + dir[0][1]);
//            dfs(Px + dir[1][0], Py + dir[1][1]);
//            dfs(Px + dir[2][0], Py + dir[2][1]);
//            dfs(Px + dir[3][0], Py + dir[3][1]);
//        }
//    }
//}

