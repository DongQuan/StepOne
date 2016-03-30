package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-30.
 * 给定一段连续的整数，求出他们中所有偶数的平方和以及所有奇数的立方和。
 */
public class P2007 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long x = in.nextLong();
            long y = in.nextLong();
            long oddSum = 0;
            long evenSum = 0;

            if (x > y) {
                long temp = x;
                x = y;
                y = temp;
            }

            for (long i = x; i <= y; i++) {
                if (i % 2 == 0) {
                    evenSum += Math.pow(i, 2);
                } else {
                    oddSum += Math.pow(i, 3);
                }
            }
            System.out.println(evenSum + " " + oddSum);
        }
    }
}
