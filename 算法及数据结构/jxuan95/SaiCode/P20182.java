package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-30.
 * 母牛生小牛问题2
 */
public class P20182 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[1000];
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        a[4] = 4;
        for (int i = 4; i < 1000; i++) {
            a[i] = a[i - 1] + a[i - 3];
        }
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) continue;
            System.out.println(a[n]);
        }
    }
}
