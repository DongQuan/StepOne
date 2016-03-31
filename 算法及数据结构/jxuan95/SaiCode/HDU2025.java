package jxuan95.SaiCode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jxuan on 16-3-31.
 * 对于输入的每个字符串，查找其中的最大字母，在该字母后面插入字符串“(max)”。
 */
public class HDU2025 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            char[] c = s.toCharArray();
            char t = '0';
            for (int i = 0; i < c.length; i++) {
                if (c[i] > t) {
                    t = c[i];
                }
            }

            for (int i = 0; i < c.length; i++) {
                System.out.print(c[i]);
                if(c[i]==t){
                    System.out.print("(max)");
                }
            }
            System.out.println();
        }
    }
}
