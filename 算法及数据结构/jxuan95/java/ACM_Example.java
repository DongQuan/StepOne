package jxuan95.java;

import java.util.Scanner;

/**
 * Created by jxuan on 16-2-24.
 * 《算法竞赛入门经典第二版》
 */
public class ACM_Example {

    /**
     * 题目：输出所有形如aabb的4位完全平方数
     * 例题2-1
     */
    public void example2_1() {
        for (int a = 1; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                int n = a * 1100 + b * 11;
                int m = (int) Math.sqrt(n);
                if (m * m == n) {
                    System.out.println(n);
                }
            }
        }
    }

    /**
     * 题目：输出所有形如aabb的4位完全平方数
     * 枚举平方根,避免开方浮点运算误差
     */
    public void example2_1_2() {
        for (int i = 1; ; i++) {
            int n = (int) Math.pow(i, 2);
            if (n < 1000) continue;
            if (n > 9999) break;
            int a = n / 100;
            int b = n % 100;
            if (a % 10 == a / 10 && b % 10 == b / 10) System.out.println(n);
        }
    }

    /**
     * 题目：对于任意大于1的自然数n，若n为奇数，则将n变为3n+1,否则变为n的一半。经过若干次这样的变换，一定会使n变为1.
     * 输入n,输出变换的次数
     * 例题2-2
     * 注意乘法溢出
     */
    public void example2_2() {
        System.out.print("请输入一个大于1的自然数：");
        Scanner in = new Scanner(System.in);
        long a = in.nextInt();
        int count = 0;
        while (a > 1) {
            if (a % 2 == 1) a = 3 * a + 1;
            else a /= 2;
            count++;
        }

        System.out.println("次数：" + count);
    }
}
