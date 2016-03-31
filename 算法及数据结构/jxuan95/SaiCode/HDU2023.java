package jxuan95.SaiCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jxuan on 16-3-31.
 * 假设一个班有n(n<=50)个学生，每人考m(m<=5)门课，求每个学生的平均成绩和每门课的平均成绩，并输出各科成绩均大于等于平均成绩的学生数量。
 */
public class HDU2023 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();

            double[][] scores = new double[n][m];
            double[] sums = new double[n];//一个学生所有的成绩和
            double[] sum = new double[m];//每门课所有学生成绩和
            int num = 0;//各科成绩大于平均成绩的学生人数
            int[] re = new int[n];//每个学生大于平均成绩的科目数
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    scores[i][j] = in.nextDouble();
                    sums[i] += scores[i][j];
                    sum[j] += scores[i][j];
                }
            }

            //每个学生的平均成绩
            for (int i = 0; i < n; i++) {
                System.out.printf("%.2f", sums[i] / m);
                if (i < n - 1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }

            //m门课的平均成绩
            for (int k = 0; k < m; k++) {
                System.out.printf("%.2f", sum[k] / n);
                if (k < m - 1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (scores[i][j] >= sum[j] / n) {
                        re[i]++;
                    }
                }
                if (re[i] == m) {
                    num++;
                }
            }
            System.out.println(num);
            System.out.println();
        }
    }
}
