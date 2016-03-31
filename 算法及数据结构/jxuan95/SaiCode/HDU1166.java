package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-31.
 * 第一行一个整数T，表示有T组数据。
 * 每组数据第一行一个正整数N（N<=50000）,表示敌人有N个工兵营地，接下来有N个正整数,第i个正整数ai代表第i个工兵营地里开始时有ai个人（1<=ai<=50）。
 * 接下来每行有一条命令，命令有4种形式：
 * (1) Add  i j,i和j为正整数,表示第i个营地增加j个人（j不超过30）
 * (2)Sub i j  ,i和j为正整数,表示第i个营地减少j个人（j不超过30）;
 * (3)Query i j ,i和j为正整数,i<=j，表示询问第i到第j个营地的总人数;
 * (4)End  表示结束，这条命令在每组数据最后出现;
 * 每组数据最多有40000条命令
 */
public class HDU1166 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int T = in.nextInt();
            int N = in.nextInt();
            int[] a = new int[N];

            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }


        }
    }
}
