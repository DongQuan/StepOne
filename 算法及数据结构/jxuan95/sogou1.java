package jxuan95;

import java.util.Scanner;

/**
 * Created by eisen on 16-9-12.
 * 求一个字符串的最大回文前缀长度。回文是指正反方向读起来都一样的字符串，比如“abcdcba”就是一个回文。
 * 输入
 * 一个文本文件，至少包含一个字节。每个字节是一个字符。最大长度可能有几十万字节。
 * 输出
 * 最大回文前缀的长度。
 */
public class sogou1 {
    private static int[] next;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String result = longestPalindrome(s);
            System.out.println(s.indexOf(result));
        }
    }

    private static void GetNext(String s) {
        int i, j;

        i = 0;
        j = -1;

        next[0] = -1;

        while (i < s.length()) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    private static int compare(String pattern, String s) {
        int i, j;

        i = 0;
        j = 0;

        int maxLen = 0;
        while (i < s.length()) {
            if (j == -1 || pattern.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j > maxLen) {
                maxLen = j;
            }
            if (j == pattern.length()) {
                return maxLen;
            }
        }
        return maxLen;
    }

    public static String longestPalindrome(String s) {
        String reverString = new StringBuilder(s).reverse().toString();
        next = new int[s.length() + 1];

        String maxPal = "";
        int maxLen = 0;
        int len;
        for (int i = 0; i < s.length(); i++) //枚举所有后缀
        {
            String suffix = reverString.substring(i);
            if (suffix.length() < maxLen) {
                break;
            }
            GetNext(suffix);
            len = compare(suffix, s);
            if (len > maxLen) {
                maxPal = suffix.substring(0, len);
                maxLen = len;
            }

        }
        return maxPal;
    }
}
