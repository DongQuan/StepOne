package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-4-1.
 * 统计每个元音字母在字符串中出现的次数。
 */
public class HDU2027 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.nextLine());
            while (n > 0) {
                n--;
                int[] num = new int[5];
                String s = in.nextLine();
                char[] c = s.toCharArray();
                for (int i = 0; i < c.length; i++) {
                    switch (c[i]) {
                        case 'a':
                            num[0]++;
                            break;
                        case 'e':
                            num[1]++;
                            break;
                        case 'i':
                            num[2]++;
                            break;
                        case 'o':
                            num[3]++;
                            break;
                        case 'u':
                            num[4]++;
                            break;
                    }
                }

                System.out.println("a:" + num[0]);
                System.out.println("e:" + num[1]);
                System.out.println("i:" + num[2]);
                System.out.println("o:" + num[3]);
                System.out.println("u:" + num[4]);
                if (n != 0) {
                    System.out.println();
                }
            }

        }
    }
}
