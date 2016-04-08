package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-4-7.
 * 输入一个十进制数N，将它转换成R进制数输出。
 */
public class HDU2031 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();//输入一个整数
            int r = in.nextInt();//要转为的二进制数

            if (n > 0) {
                util(n, r);
            } else if (n == 0) {
                System.out.println(0);
            } else {
                System.out.print("-");
                util(-n, r);
            }

            System.out.println();
        }
    }

    public static void util(int n, int r) {
        if (n > 0) {
            util(n / r, r);

            int re = n % r;
            if (re > 9) {
                System.out.print((char) (re - 10 + 'A'));
            } else {
                System.out.print(re);
            }
        }
    }
}
