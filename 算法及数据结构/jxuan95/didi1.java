package jxuan95;

import java.util.Scanner;

/**
 * Created by eisen on 16-9-18.
 * 末尾0的个数
 */
public class didi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int num = 0;
            for (int i = 1; i <= n; i++) {
                int j = i;
                while (j % 5 == 0) {
                    num++;
                    j /= 5;
                }
            }
            System.out.println(num);
        }
    }
}
