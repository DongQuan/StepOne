package jxuan95;

import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.Arrays;


/**
 * Created by eisen on 16-9-5.
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 给你两个集合，要求 {A} + {B}。
 * 注：同一个集合中不会有两个相同的元素。
 * 多组（不超过 5 组）数据。
 * 每组输入数据分为三行，第一行有两个数字 n,m($0<n,m\leq10000$)，
 * 分别表示集合 A 和集合 B 的元素个数。后两行分别表示集合 A 和集合 B。
 * 每个元素为不超出 int 范围的整数，每个元素之间有一个空格隔开。
 * 针对每组数据输出一行数据，表示合并后的集合，要求从小到大输出，每个元素之间有一个空格隔开。
 * 样例输入
 * 1 2
 * 1
 * 2 3
 * 1 2
 * 1
 * 1 2
 * 样例输出
 * 1 2 3
 * 1 2
 */
public class JDXiaozhao2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int arr[] = new int[n + m];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scan.nextInt();
            }
            Arrays.sort(arr);
            System.out.print(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    System.out.print(" " + arr[i]);
                }
            }
            System.out.println();
        }
    }
}
