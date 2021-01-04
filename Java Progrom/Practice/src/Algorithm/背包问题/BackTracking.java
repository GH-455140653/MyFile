package Algorithm.背包问题;

public class BackTracking {
    private static int[] p;//物品的价值数组
    private static int[] w;//物品的重量数组
    private static int maxWeight;//最大可以拿的重量
    private static int count;//物品的个数

    private static int cw;//当前的重量
    private static int cp;//当前的价值
    static int currentBestPrice;//目前最优装载的价值
    private static int remain;//剩余物品的价值

    private static int[] x;//存放当前解
    private static int[] best;//存放最终解

    public static int init(int[] currentWeight, int[] currentPrice, int bestPrice) {
        //初始化数据成员，数组下标从1开始
        count = currentWeight.length - 1;
        w = currentWeight;
        p = currentPrice;
        maxWeight = bestPrice;
        cw = 0;//初始化
        currentBestPrice = 0;//初始化
        x = new int[count + 1];
        best = new int[count + 1];

        //初始化r，即剩余最大价格
        for (int i = 1; i <= count; i++) {
            remain += p[i];
        }

        //调用回溯法计算
        BackTrack(1);
        return currentBestPrice;
    }

    //回溯
    public static void BackTrack(int t) {
        if (t > count) {//定义出口，判断是否到达叶结点
            if (cp > currentBestPrice) {
                for (int i = 1; i <= count; i++) {
                    best[i] = x[i];
                }
                currentBestPrice = cp;
            }
            return;
        }

        remain -= p[t];
        if (cw + w[t] <= maxWeight) {
            //搜索左子树
            x[t] = 1;
            cp += p[t];
            cw += w[t];
            BackTrack(t + 1);//进入子节点
            cp -= p[t];//恢复现场
            cw -= w[t];//恢复现场

        }

        if (cp + remain > currentBestPrice) {//剪枝操作,
            //搜索右子树
            x[t] = 0;
            BackTrack(t + 1);
        }
        remain += p[t];//恢复现场
    }


    public static void main(String[] args) {
        //测试
        int[] weights = {0, 5, 15, 25, 27, 30};//质量数组
        int[] prices = {0, 12, 30, 44, 46, 50};//价值数组
        int maxValue = 50;//最大价值/2
        init(weights, prices, maxValue);
        System.out.println("最优装载价值为：" + currentBestPrice + "\n装载的物品为：");
        for (int i = 1; i <= count; i++) {
            System.out.print(best[i] + " ");
        }
    }
}
