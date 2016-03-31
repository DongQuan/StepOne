package jxuan95.java;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-31.
 * 桌腿
 */
public class Mogujie0021 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();//桌腿总数
            int[] a = new int[n];//n条桌腿的长度
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            int[] prices = new int[n];//移除每条桌腿的代价
            for (int j = 0; j < n; j++) {
                prices[j] = in.nextInt();
            }

            /**
             * 把桌腿长度进行排序
             */
            int temp;//桌腿长度的中间量
            int t;//成本中间量，把桌腿长度进行排序之后，桌腿对应的成本也要随着桌腿长度变化
            for (int i = 0; i < a.length; i++) {
                temp = a[i];
                t = prices[i];
                int j = i + 1;
                for (; j < a.length; j++) {
                    if (a[j] < a[i]) {
                        a[i] = a[j];
                        a[j] = temp;
                        temp = a[i];

                        //把桌腿长度进行排序之后，桌腿对应的成本也要随着桌腿长度变化
                        prices[i] = prices[j];
                        prices[j] = t;
                        t = prices[i];
                    }
                }
            }

            int[] cnum = new int[205];

            for (int i = 1; i < n + 1; i++) {
                if (prices[i - 1] == i) {
                    cnum[i]++;
                }
            }

            for (int k : cnum) {
                System.out.println(k);
            }
        }
    }
}
