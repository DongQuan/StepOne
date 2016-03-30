package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-30.
 * 有一个长度为n(n<=100)的数列，该数列定义为从2开始的递增有序偶数，现在要求你按照顺序每m个数求出一个平均值，如果最后不足m个，则以实际数量求平均值。编程输出该平均值序列。
 */
public class HDU2015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();

            if (n < m) {
                int t = n;
                n = m;
                m = t;
            }
            int[] a = new int[n];

            for (int i = 0, t = 2; i < n; i++) {
                a[i] = t;
                t += 2;
            }
            int t = n;
            int i =0;
            while (t > 0) {
                int sum = 0;
                if (t > m) {
                    for (int z =0; i < n&&z<m;z++, i++, t--) {
                        sum += a[i];
                    }
                    int result = sum / m;
                    System.out.print(result + " ");
                } else {
                    int r = t;
                    for (int w = n - t; w < n; w++, t--) {
                        sum += a[w];
                    }
                    int result = sum / r;
                    System.out.println(result);
                }
            }
        }
    }
}
