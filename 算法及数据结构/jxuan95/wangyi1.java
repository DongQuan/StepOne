package jxuan95;

import java.util.Scanner;

/**
 * Created by eisen on 16-9-12.
 * abc好友
 */
public class wangyi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] s = line.split(" ");
            int x, y, z, m;
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            z = Integer.parseInt(s[2]);
            m = Integer.parseInt(s[3]);

            if (!isNumeric(s[0]) || !isNumeric(s[1]) || !isNumeric(s[2]) || !isNumeric(s[3])) {
                System.out.println("NO");
                return;
            }

            int a = (x + z) / 2;
            int b = (z - x) / 2;
            int c = (m - y) / 2;
            System.out.println(a + " " + b + " " + c);
        }
    }

    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
