package jxuan95;

import java.util.Scanner;

/**
 * Created by eisen on 16-9-12.
 * 定义两个大于2的偶数之间的距离，为这两个数之间质数的个数。从小到大输入n个大于2的偶数，
 * 输出所有数两两之间距离的总和（应该有n*(n-1)/2个距离，输出总和就好)。
 * 输入
 * 第一行是输入偶数的个数，最小为2，最大可能到几万。之后每行为一个偶数，最小是4，最大可能是几百万，不重复的升序排列。
 * 输出
 * 输入数据两两间距离的总和，这应该是一个不小于0的整数。
 */
public class sogou2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }

            int[] sum = new int[n - 1];
            for (int j = 0; j < n - 1; j++) {
//                for (int k = j + 1; k < n; k++) {
//                    sum[j] += getNum(array[j], array[k]);
//                }
                sum[j] += getNum(array[j], array[j + 1]);
            }
            int result = 0;
//            for (int k : sum) {
//                for (int i = 0, len = sum.length; i < len; i++) {
//
//                }
//                result += k;
//            }
            for (int i = 0, len = sum.length; i < len; i++) {
                result += sum[i];
            }
            System.out.println(result);
        }

    }

    public static int getNum(int num1, int num2) {
        int count = 0;
        for (int i = num1; i <= num2; i++) {
            boolean isPrime = true;
            for (int k = 2; k <= Math.sqrt(i); k++) {
                if (i % k == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
            }
        }
        return count;
    }
}
