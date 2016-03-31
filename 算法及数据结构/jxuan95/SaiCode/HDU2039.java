package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-31.
 * 给定三条边，请你判断一下能不能组成一个三角形。
 */
public class HDU2039 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            label:
            {
                int n = in.nextInt();
                while (in.hasNext()) {
                    int[] a = new int[3];
                    for (int i = 0; i < 3; i++) {
                        a[i] = in.nextInt();
                    }

                    if (a[0] + a[1] > a[2] && a[0] + a[2] > a[1] && a[1] + a[2] > a[0]) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    n--;
//                    if (n == 0) break label;
                }
            }
        }
    }
}
