package jxuan95.java;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jxuan on 16-2-28.
 * 《算法竞赛入门经典第二版》
 * 第三章
 */
public class ACM_Training_Part3 {

    /**
     * 例题：3-1
     * 读入一些整数，逆序输出到一行中
     */
    public void example3_1() {

        Scanner in = new Scanner(System.in);

        System.out.print("请输入整数个数：");
        int b = in.nextInt();
        int[] a = new int[b];
        int c = 0;

        while (c < b) {
            System.out.print("请输入整数：");
            a[c] = in.nextInt();
            c++;
        }

        System.out.println("您输入的数据是：" + Arrays.toString(a));
        System.out.print("是否需要逆序输出？[Y/N]:");
        String next = in.next();
        if (next.equals("Y")) {
            System.out.print("逆序输出:");
            for (int i = b - 1; i >= 0; i--) {
                System.out.print(a[i]);
                if (i == 0) {
                    System.out.println("");
                }
            }
        } else {
            System.out.println("程序退出");
        }
    }
}
