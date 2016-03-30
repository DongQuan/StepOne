package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-30.
 * 输入n(n<=100)个整数，按照绝对值从大到小排序后输出。题目保证对于每一个测试实例，所有的数的绝对值都不相等。
 */
public class P2020 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) continue;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            for (int j = 0; j < n; j++) {
                int temp = Math.abs(a[j]);
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(a[k]) > temp) {
                        int t2 = a[j];
                        a[j] = a[k];
                        a[k] = t2;
                        temp = Math.abs(a[j]);
                    }
                }
            }
            for (int k = 0; k < n; k++) {
                if (k < n - 1) {
                    System.out.print(a[k] + " ");
                } else {
                    System.out.println(a[k]);
                }
            }
        }
    }
}
