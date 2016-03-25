package jxuan95.java;

/**
 * Created by jxuan on 16-3-25.
 * 算法
 */
public class Arithmetic9 {
    public static void main(String[] args) {
//        System.out.println(Power2(5.0, 6));
        System.out.println(10 ^ 1101);
    }

    public double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public static double Power2(double base, int exponent) {
        int temp = Math.abs(exponent);
        double i = 1.0;
        while (temp != 0) {
            if ((temp & 1) != 0) {
                i *= base;
            }
            base *= base;
            temp >>= 1;
        }

        return exponent < 0 ? 1 / i : i;
    }
}
