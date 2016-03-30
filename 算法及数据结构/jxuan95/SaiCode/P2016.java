package jxuan95.SaiCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jxuan on 16-3-30.
 * 输入n(n<100)个数，找出其中最小的数，将它与最前面的数交换后输出这些数。
 */
public class P2016 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) continue;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int temp = a[0];
            for (int j = 0; j < n; j++) {
                if (a[j] < temp) {
                    temp = a[j];
                }
            }

            int l;
            for (int k = 0; k < n; k++) {
                if (a[k] == temp) {
                    l = k;
                    int b = a[0];
                    a[0] = temp;
                    a[l] = b;
                }
            }

            for (int i = 0; i < n - 1; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println(a[n - 1]);
        }
    }
}
