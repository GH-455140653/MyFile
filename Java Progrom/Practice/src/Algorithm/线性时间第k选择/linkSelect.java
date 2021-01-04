package Algorithm.线性时间第k选择;


import java.util.Scanner;

class RandomizedSelect {//在数组[p-r中找到第i小的元素值]

    public static int randomizedSelect(int[] a, int p, int r, int i) {
        if (p == r)//是否为只有一个元素的数组
            return a[p];
        int q = randomized_part(a, p, r);
        int k = q - p + 1;
        if (k == i)
            return a[q];
        else if (i < k)
            return randomizedSelect(a, p, q - 1, i);
        else
            return randomizedSelect(a, q + 1, r, i - k);
    }

    public static int randomized_part(int[] a, int p, int r) {
        int i = p + (int) (Math.random() * (r - p));
        swap(a, i, r);
        return partion(a, p, r);
    }

    public static int partion(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (a[j] <= x) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public static int[] arrInput() {
        System.out.println("请问你要几个数字：");
        Scanner scanner = new Scanner(System.in);
        int flag = scanner.nextInt();
        int[] arr = new int[flag];
        for (int i = 0; i < flag; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("原数组");
        printArr(arr);
        System.out.println("排序后数组：");
        bubbleSort(arr);
        printArr(arr);
        return arr;
    }

    public static int getNum() {
        System.out.println("请输入你需要获取的第k小的数据的k：");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length - 1; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int[] a) {
        for (int value : a) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = arrInput();//生成随机数组
        int key = getNum();//获取要找的第k个元素
        int res = randomizedSelect(a, 0, a.length - 1, key);//查找
        System.out.println("该数组中第" + key + "小的数字为：" + res);//输出
    }
}