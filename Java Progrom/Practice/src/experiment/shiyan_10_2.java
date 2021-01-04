package experiment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class shiyan_10_2 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = System.getProperty("user.dir") + "\\cash\\homework.txt";
        File file = new File(path);
        handle(file);
    }

    public static int randomNum() {
        return (int) (Math.random() * 100);
    }

    public static void handle(File file) throws FileNotFoundException {
        PrintWriter input = new PrintWriter(file);
        Scanner output = new Scanner(file);
        int[] arr = new int[100];

        //写入文件
        for (int i = 0; i < 100; i++) {
            int num = randomNum();
            input.print(num + " ");
        }
        input.close();

        //读取文件
        for (int i = 0; output.hasNext(); i++) {
            arr[i] = output.nextInt();
        }
        output.close();

        //数组排序
        Arrays.sort(arr);

        //循环遍历
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
