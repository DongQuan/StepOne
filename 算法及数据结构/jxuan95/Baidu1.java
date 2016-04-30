package jxuan95;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jxuan on 16-4-21.
 * 百度第一题
 */
public class Baidu1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();//n行
            int m = in.nextInt();//m列
            int k = in.nextInt();//第k个数
            int[][] a = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    a[i][j] = i * j;
                }
            }

            int[] r = new int[(n + 1) * (m + 1)];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    r[a[i][j]]++;
                }
            }

            for (int i = 0; i < r.length; i++) {
                if (k > 0) {
                    if (r[i] != 0) {
                        k -= r[i];
                    }
                } else if (r[i] != 0) {
                    while (r[i - 1] == 0) {
                        i--;
                    }
                    System.out.println(i - 1);
                    break;
                }
            }
        }
    }
}
