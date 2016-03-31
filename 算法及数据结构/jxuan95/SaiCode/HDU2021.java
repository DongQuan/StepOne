package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-31.
 * 作为杭电的老师，最盼望的日子就是每月的8号了，因为这一天是发工资的日子，养家糊口就靠它了，呵呵
 * 但是对于学校财务处的工作人员来说，这一天则是很忙碌的一天，财务处的小胡老师最近就在考虑一个问题：如果每个老师的工资额都知道，最少需要准备多少张人民币，才能在给每位老师发工资的时候都不用老师找零呢？
 * 这里假设老师的工资都是正整数，单位元，人民币一共有100元、50元、10元、5元、2元和1元六种。
 */
public class HDU2021 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) continue;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int m = in.nextInt();
                sum += m / 100;
                m %= 100;
                sum += m / 50;
                m %= 50;
                sum += m / 10;
                m %= 10;
                sum += m / 5;
                m %= 5;
                sum += m / 2;
                m %= 2;
                sum += m;
            }

            System.out.println(sum);
        }
    }
}
