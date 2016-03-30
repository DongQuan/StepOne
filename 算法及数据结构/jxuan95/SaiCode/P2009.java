package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-30.
 * 数列的定义如下：
 * 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 */
public class P2009 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            double temp = Math.sqrt(n);
            double sum = n;
            for (int i = 1; i < m; i++) {
                sum += temp;
                temp = Math.sqrt(temp);
            }
            System.out.printf("%.2f", sum);
            System.out.println();
        }
    }
}
