package jxuan95;

import java.util.Scanner;

/**
 * Created by jxuan on 16-4-27.
 * 今日头条算法第二题
 */
public class TodayNews2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();//第一个输入的字符串
            int n = in.nextInt();//n个操作
            while (n > 0) {
                int p = in.nextInt();
                int l = in.nextInt();
                String s1 = s.substring(0, p + l);//p+l前面的串
                String s2 = s.substring(p + l, s.length());//p+l后面的串
                String res = reversal(s.substring(p, p + l));

                s = s1 + res + s2;

                n--;
            }

            System.out.println(s);
        }
    }

    /**
     * 翻转这个字符串
     *
     * @param s 传入一个字符串
     * @return 返回结果
     */
    public static String reversal(String s) {
        char[] c1 = s.toCharArray();
        char[] c2 = new char[c1.length];
        for (int i = 0, j = c1.length - 1; i < c1.length; i++, j--) {
            c2[j] = c1[i];
        }

        return new String(c2);
    }
}
