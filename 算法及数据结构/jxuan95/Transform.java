package jxuan95;
/**
 * Created by jxuan on 16-4-19.
 */

import java.util.*;

public class Transform {

    public static void main(String[] args) {
        System.out.println(trans("This is a sample", 16));
    }

    public static String trans(String s, int n) {
        // write code here

        char[] c = s.toCharArray();

        int counter = 0;

        for (int i = 0; i < c.length; i++) {

            int temp = (int) c[i];
            if (temp <= 90 && temp >= 65) {  //  array[i]为大写字母
                c[i] = (char) (temp + 32);
            } else if (temp <= 122 && temp >= 97) {  //  array[i]为小写字母
                c[i] = (char) (temp - 32);
            }

            if (c[i] == ' ') {
                counter++;//记录有多少个空格
            }
        }

        s = new String(c);

        String[] r2 = new String[++counter];
        int j = counter - 1;
        for (int i = 0, k = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                r2[j] = s.substring(k, i);
                j--;
                k = i;
            } else if (i == c.length - 1) {
                r2[j] = s.substring(k, i + 1);
            }
        }

        String result = "";

        for (int i = 0; i < r2.length; i++) {
            if (i < r2.length - 1) {
                result += r2[i].trim() + " ";
            } else {
                result += r2[i].trim();
            }
        }

        return result;
    }
}
