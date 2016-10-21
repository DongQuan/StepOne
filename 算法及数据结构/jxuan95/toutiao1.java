package jxuan95;

import java.util.Scanner;

/**
 * Created by eisen on 16-9-21.
 * 今日头条1
 */
public class toutiao1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] line1 = in.nextLine().split(" ");
            String[] line2 = in.nextLine().split(" ");
            int m = Integer.parseInt(line1[1]);
            int len = line2.length;
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(line2[i]);
            }
            int count = 0;
            String temp = Integer.toBinaryString(m);
            System.out.println(temp);
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    if ((arr[i] ^ arr[j]) > m) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
