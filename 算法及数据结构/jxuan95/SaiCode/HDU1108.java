package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-31.
 * 给定两个正整数，计算这两个数的最小公倍数。
 */
public class HDU1108 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (n < m) {
                int t = n;
                n = m;
                m = t;
            }
            int r = n * m;

            //求最大公约数
            while (n != m) {
                if (m == 0) break;
                int t = n % m;
                n = m;
                m = t;
            }

            int result = r / n;
            System.out.println(result);
        }
    }
}
