package jxuan95.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jxuan95 on 16-2-28.
 * 《算法竞赛入门经典第二版》
 * 第三章
 */
public class ACM_Training_Part3 {

    /**
     * 例题：3-1
     * 读入一些整数，逆序输出到一行中
     */
    public void example3_1() {

        Scanner in = new Scanner(System.in);

        System.out.print("请输入整数个数：");
        int b = in.nextInt();
        int[] a = new int[b];
        int c = 0;

        while (c < b) {
            System.out.print("请输入整数：");
            a[c] = in.nextInt();
            c++;
        }

        System.out.println("您输入的数据是：" + Arrays.toString(a));
        System.out.print("是否需要逆序输出？[Y/N]:");
        String next = in.next();
        if (next.equals("Y")) {
            System.out.print("逆序输出:");
            for (int i = b - 1; i >= 0; i--) {
                System.out.print(a[i]);
                if (i == 0) {
                    System.out.println("");
                }
            }
        } else {
            System.out.println("程序退出");
        }
    }

    /**
     * 例题：3-2
     * 开灯问题
     */
    public void example3_2() {
        Scanner in = new Scanner(System.in);
        System.out.print("输入灯的盏数：");
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = 1;
        }

        System.out.print("请输入人数：");
        int m = in.nextInt();
        if (m < n) {
            for (int j = 2; j <= m; j++) {
                for (int k = 1; j * k < a.length; k++) {
                    if (a[j * k - 1] == 0) {
                        a[j * k - 1] = 1;
                    } else {
                        a[j * k - 1] = 0;
                    }
                }
            }

            for (int z = 0; z < a.length; z++) {
                if (a[z] == 1) {
                    System.out.print(z + 1 + " ");
                }
            }
        } else {
            System.out.println("输出有误");
        }
    }

    /**
     * 例题：3-3
     * 蛇形田数问题
     * P39
     * bug:最后一个数填不上
     */
    public void example3_3() {
        System.out.println("请输入一个整数：");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        int value = 1;
        int x = 0;
        int y = n - 1;
//        a[0][n - 1] = 1;
//        a[1][n - 1] = 2;
//        a[2][n - 1] = 3;
//        a[3][n - 1] = 4;
//        a[3][n - 2] = 5;
//        a[3][n - 3] = 6;
//        a[3][n - 4] = 7;
//        a[2][n - 4] = 8;
//        a[1][n - 4] = 9;
//        a[0][n - 4] = 10;

        for (int t = 0; t < n; t++) {
            for (int k = 0; k < n; k++) {
                a[t][k] = 0;
            }
        }

        while (value < n * n) {
            while (x + 1 < n && a[x + 1][y] == 0) {
                a[x][y] = value;
                x++;

                value++;
            }
            while (y > 0 && a[x][y - 1] == 0) {
                a[x][y] = value;
                y--;

                value++;
            }
            while (x > 0 && a[x - 1][y] == 0) {
                a[x][y] = value;
                x--;
                value++;
            }
            while (y + 1 < n && a[x][y + 1] == 0) {
                a[x][y] = value;
                y++;
                value++;
            }
        }

        for (int l = 0; l < n; l++) {
            for (int c = 0; c < n; c++) {
                if (c != n - 1) {
                    System.out.print(a[l][c] + "   ");

                } else {
                    System.out.println(a[l][c]);
                }
            }
        }

    }

    /**
     * 例题3-2：WERTYU
     * P47
     */
    public void example3_4() {
        char[] cs = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', '[', 'a',
                's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';', 'z', 'x', 'c', 'v'
                , 'b', 'n', 'm', ',', '.', '/'};

        System.out.println("请输入");
        Scanner in = new Scanner(System.in);

        String string = in.nextLine();
        char[] test = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            for (char j : cs) {
                if (c == 32) {
                    test[i] = 'B';
                    break;
                }

                if (j == c) {
                    test[i] = cs[new String(cs).indexOf(j) - 1];
                }
            }
        }

        for (char k : test) {
            if (k == 'B') System.out.print(" ");
            else System.out.print(k);
        }
    }

    /**
     * 程序3-7：回文串和镜像串
     * P49
     * 未完成
     */
    public void example3_7() {
        System.out.println("请输入一个大写的字符串：");

        Scanner in = new Scanner(System.in);

        String string = in.next();

        if (string != null) {
            int length = string.length();
            boolean p = true, m = true;
            for (int i = 0; i < length; i++) {
                if (string.charAt(i) != string.charAt(length - 1 - i)) {
                    p = false;
                }

                if (checkMirror(string.charAt(i)) != checkMirror(string.charAt(length - 1 - i))) {
                    m = false;
                }
            }

            if (p && m) {
                System.out.println("is a mirrored palindrome.");
            } else if (p) {
                System.out.println("is a regular palindrome.");
            } else if (m) {
                System.out.println("is a mirrored string.");
            } else {
                System.out.println("is not a palindrome.");
            }
        }


    }

    private int checkMirror(char c) {
        if (Character.isDigit(c)) return c;
        else return c - 'A';
    }

    /**
     * 例题3-4：猜数字游戏的提示
     * P50
     */
    public void example3_8() {

    }

    /**
     * 例题3-5：生成元
     * P52
     */
    public void example3_9() {
        System.out.print("请输入一个数字：");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n >= 1 && n <= 100000) {
            int count = 0;
            ArrayList<Integer> a = new ArrayList<Integer>();
            while (count <= n) {
                int length = String.valueOf(count).length();
                int sum = count;
                ArrayList<Integer> c = new ArrayList<Integer>();
                for (int i = 0; i < length; i++) {
                    c.add(count / (int) Math.pow(10, length - 1 - i) % 10);
                }
//                for (int j = 0; j < c.size(); j++) {
//                    sum += c.get(j);
//                }
                for (int j : c) {
                    sum += j;
                }
                if (sum == n) {
                    a.add(count);
                }
                count++;
//                System.out.println(c);
            }

            int length = a.size();
            for (int r = 0; r < length - 1; r++) {
                for (int t = 0; t < length - 1 - r; t++) {
                    if (a.get(t) > a.get(t + 1)) {
                        int temp = a.get(t);
                        a.remove(t);
                        a.add(t, a.get(t + 1));
                        a.remove(t + 1);
                        a.add(t + 1, temp);
                    }
                }
            }

            if (a.size() != 0) {
                System.out.println("最小" + a.get(0));

            } else {
                System.out.println("0");
            }

        } else {
            System.out.println("输入非法！");
        }
    }

    /**
     * 例题3-5：生成元（效率更高的算法）
     * P52
     * 思路：先枚举出1到100000之间所有数和它的各个数字之和n，然后定义一个数组，该数组的n这个位置就存放那个数字i
     */
    public void example3_9_2() {
        System.out.print("请输入一个数字：");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n >= 1 && n <= 100000) {
            int max = 100000;
            int[] array = new int[1000000];
            for (int i = 0; i < max; i++) {
                int x = i, y = i;
                while (x > 0) {
                    y += x % 10;
                    x = x / 10;
                }
                if (array[y] == 0 || i < array[y]) {
                    array[y] = i;
                }
            }
            System.out.println(array[n]);
        } else {
            System.out.println("输入非法！");
        }
    }


}
