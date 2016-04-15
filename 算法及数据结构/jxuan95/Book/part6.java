package jxuan95.Book;

import java.util.Scanner;

/**
 * Created by jxuan on 16-4-15.
 * 进军硅谷
 */
public class part6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int sum = in.nextInt();
            int[] a = new int[]{1, 5, 7, 3};
            int i = 0, j = a.length - 1;
            while (i < j) {
                if (a[i] + a[j] == sum) {
                    System.out.println(a[i] + "+" + a[j] + "=" + sum);
                    break;
                } else if (a[i] + a[j] > sum) {
                    j--;
                } else {
                    i++;
                }
            }
        }
    }
}