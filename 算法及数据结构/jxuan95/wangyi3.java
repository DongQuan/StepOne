package jxuan95;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by eisen on 16-9-12.
 * 圆半径问题
 */
public class wangyi3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int radius = in.nextInt();
            int count = 0;
            for (int i = -radius; i < radius; i++) {
                double temp = Math.sqrt(Math.pow(radius, 2) - Math.pow(i, 2));
//                System.out.println(Double.toString(temp));
//                System.out.println(Math.pow(radius, 2));
//                System.out.println(i);
//                System.out.println(Math.pow(2, i));
                if (String.valueOf(Double.toString(temp).charAt(Double.toString(temp).indexOf(".") + 1)).equals("0")) {
                    count++;
                }
            }
            System.out.println(count * 2);
        }
    }
}
