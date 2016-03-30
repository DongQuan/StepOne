package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-30.
 * 多项式的描述如下：
 * 1 - 1/2 + 1/3 - 1/4 + 1/5 - 1/6 + ...
 * 现在请你求出该多项式的前n项的和。
 */
public class P2011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = in.nextInt();
            }

            for (int k = 0; k < a.length; k++) {
                double sum = 0;
                for (int j = 1; j <= a[k]; j++) {
                    sum += Math.pow(-1, j + 1) * (1.0 / j);
                }
                System.out.printf("%.2f", sum);
                System.out.println();
            }
        }
    }
}
