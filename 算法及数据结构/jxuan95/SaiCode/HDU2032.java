package jxuan95.SaiCode;

import java.util.Scanner;
import java.util.Arrays;

public class HDU2032 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                a[i][0] = 1;
                a[i][i] = 1;
            }

            for (int i = 2; i < n; i++) {
                for (int j = 1; j <= i; j++) {
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                }
            }
        }
    }
}
