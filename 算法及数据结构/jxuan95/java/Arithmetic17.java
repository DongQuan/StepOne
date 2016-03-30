package jxuan95.java;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-30.
 * 统计给定的n个数中，负数、零和正数的个数。
 */
public class Arithmetic17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int posNum = 0;
            int negaNum = 0;
            int zeroNum = 0;
            int n = in.nextInt();
            if (n == 0) {
                continue;
            }
            double[] a = new double[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextDouble();
            }
            for (double j : a) {
                if (j < 0) {
                    negaNum++;
                } else if (j > 0) {
                    posNum++;
                } else {
                    zeroNum++;
                }
            }

            System.out.println(negaNum + " " + zeroNum + " " + posNum);
        }
    }
}
