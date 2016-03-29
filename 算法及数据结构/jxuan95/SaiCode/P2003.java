package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-29.
 * 求实数的绝对值。
 */
public class P2003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double n = in.nextDouble();
            System.out.printf("%.2f", Math.abs(n));
            System.out.println();
        }
    }
}
