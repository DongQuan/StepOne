package jxuan95.SaiCode;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by jxuan on 16-3-29.
 * 输入两点坐标（X1,Y1）,（X2,Y2）,计算并输出两点间的距离。
 */
public class P2001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double[] array = new double[4];
            for (int i = 0; i < 4; i++) {
                array[i] = in.nextDouble();
            }
            double result = Math.sqrt(Math.pow(array[0] - array[2], 2) + Math.pow(array[1] - array[3], 2));
            System.out.printf("%.2f",result);
            System.out.println();
        }
    }
}