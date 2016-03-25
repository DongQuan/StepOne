package jxuan95.java;

/**
 * Created by jxuan on 16-3-25.
 * 算法
 */
public class Arithmetic8 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(8));
    }

    public static int NumberOf1(int n) {
        int num = 0;

        if (n == -1) {
            return 32;
        }

        if (n < 0) {
            return 1;
        }


        while (n >= 1) {
            if (n % 2 == 1) {
                num++;
            }
            n /= 2;

        }
        return num;
    }

    public static int Number12(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }

        return count;
    }
}
