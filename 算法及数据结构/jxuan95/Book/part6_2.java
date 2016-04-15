package jxuan95.Book;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jxuan on 16-4-15.
 * 最大下标距离
 */
public class part6_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();//数组有n个元素
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            boolean[] tag = new boolean[a.length];
            int min = a[0];
            for (int i = 0; i < n; i++) {
                if (a[i] < min) {
                    //标记下降序列，如果比前面的数小，就标记为true
                    tag[i] = true;
                    min = a[i];
                }
            }

            int maxDisc = 0, i = n - 1, j = n - 1;
            while (i >= 0) {
                if (tag[i] == false) {
                    i--;
                    continue;
                }

                while ((a[j] <= a[i]) && j > i) {
                    j--;
                }

                if (j - i > maxDisc) {
                    maxDisc = j - i;
                }
                i--;
            }

            System.out.println(maxDisc);

        }
    }
}
