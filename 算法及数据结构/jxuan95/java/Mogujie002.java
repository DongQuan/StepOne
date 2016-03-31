package jxuan95.java;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-31.
 * 蘑菇街算法2修理桌子
 */
public class Mogujie002 {
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

            int[] result = new int[n];//表示每个长度作为最后一根的时候需要的成本
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[j] > a[i]) {
                        result[i] += prices[j];
                    }
                }
            }
            for (int k : result) {
                System.out.println(k);
            }
        }
    }
}
