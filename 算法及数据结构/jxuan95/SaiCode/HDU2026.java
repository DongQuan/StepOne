package jxuan95.SaiCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jxuan on 16-3-31.
 * 输入一个英文句子，将每个单词的第一个字母改成大写字母。
 */
public class HDU2026 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            char[] c = s.toCharArray();
            c[0] = Character.toUpperCase(c[0]);
            for (int i = 1; i < c.length; i++) {
                if (c[i - 1] == ' ') {
                    c[i] = Character.toUpperCase(c[i]);
                }
            }

            for (int i = 0; i < c.length - 1; i++) {
                System.out.print(c[i]);
            }
            System.out.println(c[c.length - 1]);
        }
    }
}
