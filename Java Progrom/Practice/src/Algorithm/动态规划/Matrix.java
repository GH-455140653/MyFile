package Algorithm.动态规划;

public class Matrix {
    public void MatrixChain(int[] p, int n, int[][] m, int[][] s) {//数组p传递矩阵转化为一维的行列数字，n为矩阵个数，数组m记录连乘次数，数组p记录矩阵断开点
        //对角线赋值为0
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        //计算最优值
        for (int r = 2; r <= n; r++) {
            for (int i = 1; i <= n - r + 1; i++) {
                int j = i + r - 1;
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
                s[i][j] = i;
                for (int k = i + 1; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public static int getMatrixChain(int i, int j, int[] p) {
        int min = 0;
        if (i == j) {
            return 0;
        }
        for (int r = i; r < j; r++) {
            int times = getMatrixChain(i, r, p) + getMatrixChain(r + 1, j, p) + p[i - 1] * p[r] * p[j];
            if (r == i) {
                min = times;
            }
            if (min > times) {
                min = times;
            }
        }
        return min;
    }

    public void TraceBack(int i, int j, int[][] s) {
        //寻找连乘矩阵（最优解），自底向上寻找
        if (i == j) return;
        TraceBack(i, s[i][j], s);
        TraceBack(s[i][j] + 1, j, s);
        System.out.println("(A" + i + s[i][j] + "*A" + (s[i][j] + 1) + j + ")");
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int n = 7;
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];
        int l = p.length - 1;
        int Dymax = 0;

        System.out.println("最优值矩阵：");
        matrix.MatrixChain(p, l, m, s);
        for (int i = 1; i < n; i++) {//打印输出连乘次数
            for (int j = 1; j < n; j++) {
                System.out.print(m[i][j] + "\t");
                if (i == 1) Dymax = m[i][j];//获取动态规划方法中的求出的最大值
            }
            System.out.println();
        }

        System.out.println("\n最优解矩阵：");
        for (int i = 1; i < n; i++) {//打印矩阵连乘断开点（加括号的地方）
            for (int j = 1; j < n; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n矩阵连乘结果输出：");
        matrix.TraceBack(1, 6, s);//打印矩阵连乘的路径（括号如何添加）
        System.out.print("\n递归——矩阵连乘最优值：");
        System.out.println(getMatrixChain(1, 6, p));
        System.out.println("动态规划——矩阵连乘最优值：" + Dymax);
    }
}