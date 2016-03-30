package jxuan95.java;

import java.util.ArrayList;

/**
 * Created by jxuan on 16-3-30.
 * /**
 * 获得两个整形二进制表达位数不同的数量
 *
 */
public class Arithmetic16 {

    public static void main(String[] args) {
        System.out.println(countBitDiff(0, 0));
    }

    public static int countBitDiff(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        int[] ma = new int[32];
        int[] na = new int[32];
        int i = ma.length;
        int j = na.length;
        int result = 0;


        while (m >= 1 && i >= 0) {
            ma[i - 1] = (m % 2);
            m /= 2;
            i--;
        }

        while (n >= 1 && j >= 0) {
            na[j - 1] = (n % 2);
            n /= 2;
            j--;
        }

        for (int k = 0; k < ma.length; k++) {
            if (ma[k] != na[k]) {
                result++;
            }
        }
        System.out.println(result);

        return result;
    }

    public static int countBitDiff2(int m, int n) {
        int r = m ^ n;
        int count = 0;
        int i = 0;
        while (i < 32) {
            if (((r >> i) & 1) != 0) {
                count++;
            }
            i++;
        }

        return count;
    }
}
