package jxuan95;

import java.util.Scanner;

/**
 * Created by eisen on 16-9-13.
 * 百度算法1，颜色反转
 */
public class baiduoj1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            String s = line.substring(1, line.length());
            String[] c = s.split("");
            for (int i = 0, len = c.length; i < len; i++) {
                c[i] = Integer.toHexString(15 - Integer.valueOf(c[i], 16)).toUpperCase();
            }

            String result = "#";
            for (String ss : c) {
                result += ss;
            }
            System.out.println(result);
        }
    }
}
