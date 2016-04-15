package jxuan95.Book;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jxuan on 16-4-15.
 * 6-1
 */

public class part6_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int k = in.nextInt();
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextInt();
            }

            reverse(a, 0, a.length - 1);//把整个数组反转
            reverse(a, 0, k - 1);//把前k个数反转
            reverse(a, k, a.length - 1);//把剩下的数反转

            System.out.println(Arrays.toString(a));

        }
    }

    //辅助函数，从start到end的数反转
    public static void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[end];
            a[end] = a[start];
            a[start] = temp;
            start++;
            end--;
        }
    }
}
