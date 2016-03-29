package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-30.
 * 给你n个整数，求他们中所有奇数的乘积。
 * 输入数据包含多个测试实例，每个测试实例占一行，每行的第一个数为n，表示本组数据一共有n个，接着是n个整数，你可以假设每组数据必定至少存在一个奇数。
 */
public class P2006 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] array = new int[n];
            int result = 1;
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
                if (array[i] % 2 == 1) {
                    result *= array[i];
                }
            }
//            for (int j : array) {
//                if (j % 2 == 1) {
//                    result *= j;
//                }
//            }
            System.out.println(result);
        }
    }
}
