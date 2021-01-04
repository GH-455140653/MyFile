package Algorithm.线性时间第k选择;

import java.util.ArrayList;
import java.util.Scanner;

public class select {
    static int midValue;
    static int value;

    public static void main(String[] args) {
        int[] arr;//定义数组
        int key;
        arr = arrInput();//给数组赋值
        key = getNum();
        printArr(arr);//打印原始数组
        getMid(arr, key);
//        bubbleSort(arr);//给数组排序
//        printArr(arr);//打印排序后数组数组
//        findMid(arr);
    }

    public static int[] arrInput() {
//        ArrayList<Object> list = new ArrayList<>();
//
//        Scanner scanner = new Scanner(System.in);
//        for (int i = 0; true; i++) {
//            if (i == 0) {
//                System.out.println("请输入你的数组（输入负数结束）:");
//            }
//            list.add(scanner.nextInt());
//            if ((int) (list.get(i)) < 0) {
//                list.remove(i);
//                break;
//            }
//        }
//        int[] arr = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            arr[i] = (int) (list.get(i));
//        }
//        return arr;
        System.out.println("请问你要几个数字：");
        Scanner scanner = new Scanner(System.in);
        int flag = scanner.nextInt();
        int[] arr = new int[flag];
        for (int i = 0; i < flag; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
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

    public static void getMid(int[] arr, int key) {
        ArrayList<Integer> mid = new ArrayList<>();
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }//将数组写入集合

        int group = arr.length / 5;//分成几组
        int[] s = new int[5];//定义一个数组大小为5的子数组
        for (int i = 0; i <= list.size(); i++) {
            if (i != 0) {
                while (i % 5 == 0) {
                    bubbleSort(s);
                    printArr(s);
                    mid.add(s[s.length / 2]);
                    count++;
                    break;
                }
            }
            if (list.size() > i) s[i % 5] = list.get(i);//控制数组下标赋值，防止重复
        }

        int[] Mid = new int[mid.size()];
        for (int i = 0; i < mid.size(); i++) {
            Mid[i] = mid.get(i);
        }
        bubbleSort(Mid);
        printArr(Mid);
        midValue = Mid[Mid.length / 2];
        find(arr, key, list);
    }

    public static void find(int[] arr, int key, ArrayList<Integer> list) {
        int big = 0, small = 0;
        ArrayList<Integer> slist = new ArrayList<>();
        ArrayList<Integer> blist = new ArrayList<>();
        int[] subarr;
        for (int i : arr) {
            if (i < midValue) {
                slist.add(arr[i]);
                small++;
            } else {
                blist.add(arr[i]);
                big++;
            }
        }
        if (key > small + 1) {
            subarr = new int[blist.size()];
        } else {
            subarr = new int[slist.size()];
        }
    }

    public static void printArr(int[] a) {
        for (int value : a) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

class newThread implements Runnable {

    @Override
    public void run() {

    }
}
