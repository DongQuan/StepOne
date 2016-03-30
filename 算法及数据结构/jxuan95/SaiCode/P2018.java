package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-30.
 * 有一头母牛，它每年年初生一头小母牛。每头小母牛从第四个年头开始，每年年初也生一头小母牛。请编程实现在第n年的时候，共有多少头母牛？
 */
public class P2018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) continue;
            switch (n) {
                case 1:
                    System.out.println(1);
                    break;
                case 2:
                    System.out.println(2);
                    break;
                case 3:
                    System.out.println(3);
                    break;
                case 4:
                    System.out.println(4);
                    break;
            }

            if (n > 4) {
                System.out.println(ne(n));
            }
        }
    }

    public static int ne(int m) {
        switch (m) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
        }

        return ne(m - 1) + ne(m - 3);
    }
}
