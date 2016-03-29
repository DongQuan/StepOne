package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-30.
 * 春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，他是这样定义的：
 * “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。
 * 现在要求输出所有在m和n范围内的水仙花数。
 */
public class P2010 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int num = 0;
            for (; m <= n; m++) {
                if (m == (Math.pow(m % 10, 3) + Math.pow((m / 10) % 10, 3) + Math.pow((m / 100) % 10, 3))) {
                    System.out.print(m + " ");
                    num++;
                }
            }
            if (num == 0) {
                System.out.println("no");
            }
        }
    }
}
