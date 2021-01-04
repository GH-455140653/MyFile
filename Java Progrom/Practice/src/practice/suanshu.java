package practice;

import java.util.Scanner;

public class suanshu {
    public static void main(String[] args) {
        double L, C, K, T;
        Scanner sc = new Scanner(System.in);
//        C = sc.nextDouble();
//        K = sc.nextDouble();
//        T = sc.nextDouble();
//        L = C * Math.pow(K, 1.0 / 3) * Math.pow(T, 4.0 / 3);
        L = sc.nextDouble();
        C = sc.nextDouble();
        double E = 2.4 * (L / 1000) * 1.05;
        K = 120000.0 / 365 * C * E;
        System.out.println("工作量=" + E + "\n成本=" + K);
    }
}
