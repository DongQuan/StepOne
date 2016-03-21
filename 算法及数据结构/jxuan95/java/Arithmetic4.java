package jxuan95.java;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-21.
 * 网易2016算法2
 */
public class Arithmetic4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int r = in.nextInt();

            int[] a = new int[6];
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextInt();
            }

            int x0 = in.nextInt();
            int y0 = in.nextInt();

            int c = 0;
            for (int j = 0; j < 6; j++, j++) {
                if (getT(a[j], a[j + 1], x0, y0, r) <= 0) {
                    c++;
                }
            }

            System.out.println(c + "x");
        }
    }

    public static double getT(int x1, int y1, int x0, int y0, int r) {
        return Math.sqrt(Math.pow(x1 - x0, 2) + Math.pow(y1 - y0, 2)) - r;
    }
}
