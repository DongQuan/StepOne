package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-29.
 * 根据输入的半径值，计算球的体积。
 */
public class P2002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final double PI = 3.1415927;
        while (in.hasNext()) {
            double r = in.nextDouble();
            double v = (PI * Math.pow(r, 3) * 4) / 3;
            System.out.printf("%.3f", v);
            System.out.println();
        }
    }
}
