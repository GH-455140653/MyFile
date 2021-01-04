package Algorithm.动态规划;

public class DNAmatch {
    public static void main(String[] args) {
        String[] DNA1 = {"G", "C", "C", "C", "T", "A", "G", "C", "G"};
        String[] DNA2 = {"G", "C", "G", "C", "", "A", "A", "T", "G"};
        int[][] DNA = new int[DNA1.length + 1][DNA2.length + 1];//定义数组，给空情况留位置
        DNA[0][0] = 0;//空空赋值
        /*给空的行列赋值为DNA[0][0]的-2递减序列*/
        for (int i = 1; i <= DNA1.length; i++) {
            DNA[i][0] = DNA[i - 1][0] - 2;
        }
        for (int i = 1; i <= DNA2.length; i++) {
            DNA[0][i] = DNA[0][i - 1] - 2;
        }

        int flag;//默认不等，数值-1
        for (int i = 1; i <= DNA1.length; i++) {
            for (int j = 1; j <= DNA2.length; j++) {
                flag = -1;
                if (DNA1[i - 1].equals(DNA2[j - 1])) {
                    flag = 1;//匹配相等，数值+1
                }
                //三种情况下取出最大值，
                DNA[i][j] = Math.max(DNA[i - 1][j] - 2, DNA[i][j - 1] - 2);//左边-2和上面-2取出最大值
                DNA[i][j] = Math.max(DNA[i][j], DNA[i - 1][j - 1] + flag);//左，上，对角取最大值
            }
        }
        //遍历数组找出分数的最大值
        int max = DNA[0][0];
        for (int[] rows : DNA) {
            for (int cols : rows) {
                if (max < cols) {
                    max = cols;
                }
            }
        }
        System.out.println("最终分数为：" + max);
    }
}
