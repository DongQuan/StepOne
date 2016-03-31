package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-31.
 * 有一楼梯共M级，刚开始时你在第一级，若每次只能跨上一级或二级，要走上第M级，共有多少种走法？
 */
public class HDU2041 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int m = in.nextInt();
                int r = Run(m);
                System.out.println(r);
            }
        }
    }

    public static int Run(int n) {
        if (n <= 0) {
            return -1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return Run(n - 1) + Run(n - 2);
        }
    }
}
