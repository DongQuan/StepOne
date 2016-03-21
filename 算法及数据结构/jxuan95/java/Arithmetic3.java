package jxuan95.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jxuan on 16-3-21.
 * 网易2016真题模拟
 * 小易经常沉迷于网络游戏.有一次,他在玩一个打怪升级的游戏,他的角色的初始能力值为 a.在接下来的一段时间内,他将会依次遇见n个怪物,每个怪物的防御力为b1,b2,b3...bn. 如果遇到的怪物防御力bi小于等于小易的当前能力值c,那么他就能轻松打败怪物,并 且使得自己的能力值增加bi;如果bi大于c,那他也能打败怪物,但他的能力值只能增加bi 与c的最大公约数.那么问题来了,在一系列的锻炼后,小易的最终能力值为多少?

 * 输入描述:
 * 对于每组数据,第一行是两个整数n(1≤n<100000)表示怪物的数量和a表示小易的初始能力值.
 * 第二行n个整数,b1,b2...bn(1≤bi≤n)表示每个怪物的防御力


 * 输出描述:
 * 对于每组数据,输出一行.每行仅包含一个整数,表示小易的最终能力值

 * 输入例子:
 * 3 50
 * 50 105 200
 * 5 20
 * 30 20 15 40 100

 * 输出例子:
 * 110
 * 205
 */
public class Arithmetic3 {
    public static void main(String[] args) {
        getC();
    }

    public static int getC() {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();//输入怪物数量和初始能力值
        String s2 = in.nextLine();//输入每个怪物的防御力

        ArrayList<Integer> b1 = stringToArray(s1);
        ArrayList<Integer> b2 = stringToArray(s2);

        System.out.println("第一行输入：" + b1);
        System.out.println("第二行输入：" + b2);

        int c = b1.get(1);//初始能力值


        for (int i = 0; i < b2.size(); i++) {
            if (b2.get(i) <= c) {
                c += b2.get(i);
            } else {
                c += maxCommonDivisor(c, b2.get(i));
            }
        }
        System.out.println(c);
        return c;
    }

    public static ArrayList<Integer> stringToArray(String line) {
        ArrayList<Integer> b = new ArrayList<>();
        String[] c = line.split("\\s+");
        for (String t : c) {
            b.add(Integer.parseInt(t));
        }
        return b;
    }

    public static int maxCommonDivisor(int m, int n) {
        if (m < n) {// 保证m>n,若m<n,则进行数据交换
            int temp = m;
            m = n;
            n = temp;
        }
        if (m % n == 0) {// 若余数为0,返回最大公约数
            return n;
        } else { // 否则,进行递归,把n赋给m,把余数赋给n
            return maxCommonDivisor(n, m % n);
        }
    }
}
