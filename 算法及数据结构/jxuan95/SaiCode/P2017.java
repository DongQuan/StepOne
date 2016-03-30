package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-30.
 * 对于给定的一个字符串，统计其中数字字符出现的次数。
 */
public class P2017 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String[] s = new String[n];

            for (int i = 0; i < n; i++) {
                s[i] = in.next();
            }

            for (int j = 0; j < n; j++) {
                char[] c = s[j].toCharArray();
                int num = 0;
                for (char t : c) {
                    if (Character.isDigit(t)) {
                        num++;
                    }
                }
                System.out.println(num);
            }
        }
    }
}
