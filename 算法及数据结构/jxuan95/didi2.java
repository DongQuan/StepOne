package jxuan95;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by eisen on 16-9-18.
 * 地下迷宫
 */
public class didi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] s = line.split(" ");
            int[] first = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                first[i] = Integer.parseInt(s[i]);
            }
            int n = first[0];
            int m = first[1];
            int p = first[2];

            int[][] maze = new int[n][m];

            for (int i = 0; i < n; i++) {
                String line2 = in.nextLine();
                String[] s2 = line2.split(" ");
                for (int j = 0; j < m; j++) {
                    maze[i][j] = Integer.parseInt(s2[j]);
                }
            }

//            for (int[] t : maze) {
//                System.out.println(Arrays.toString(t));
//            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                }
            }
            System.out.println("Can not escape!");
        }
    }
}
