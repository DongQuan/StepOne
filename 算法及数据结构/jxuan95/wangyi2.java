package jxuan95;

import java.util.Scanner;

/**
 * Created by eisen on 16-9-12.
 * 数字翻转
 */
public class wangyi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] s = line.split(" ");
            s[0] = new StringBuffer(s[0]).reverse().toString();
            s[1] = new StringBuffer(s[1]).reverse().toString();

            int temp = Integer.parseInt(s[0]) + Integer.parseInt(s[1]);

            int result = 0;
            while (true) {
                int n = temp % 10;

                result = result * 10 + n;
                temp = temp / 10;
                if (temp == 0) {
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
