package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-31.
 * 有n(n<=100)个整数，已经按照从小到大顺序排列好，现在另外给一个整数x，请将该数插入到序列中，并使新的序列仍然有序。
 */
public class HDU2019 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == 0 && m == 0) continue;
            int[] a = new int[n + 1];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            for (int k = 0; k < a.length; k++) {
                if (a[k] < m && a[k + 1] > m) {
                    int temp = k + 1;
                    int c = a.length - 1;
                    while ((c > k + 1) && (c < a.length)) {
                        a[c] = a[c - 1];
                        c--;
                    }
                    a[temp] = m;
                } else if (a[k] < m && a[k + 1] == 0) {
                    a[k + 1] = m;
                }
            }

            for (int j = 0; j < a.length - 1; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println(a[a.length - 1]);
        }
    }

}
