package jxuan95.java;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jxuan95 on 16-2-24.
 * 《算法竞赛入门经典第二版》
 * 第二章
 */
public class ACM_Training_Part2 {

    /**
     * 题目：输出所有形如aabb的4位完全平方数
     * 例题2-1
     */
    public void example2_1() {
        for (int a = 1; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                int n = a * 1100 + b * 11;
                int m = (int) Math.sqrt(n);
                if (m * m == n) {
                    System.out.println(n);
                }
            }
        }
    }

    /**
     * 题目：输出所有形如aabb的4位完全平方数
     * 枚举平方根,避免开方浮点运算误差
     */
    public void example2_1_2() {
        for (int i = 1; ; i++) {
            int n = (int) Math.pow(i, 2);
            if (n < 1000) continue;
            if (n > 9999) break;
            int a = n / 100;
            int b = n % 100;
            if (a % 10 == a / 10 && b % 10 == b / 10) System.out.println(n);
        }
    }

    /**
     * 题目：对于任意大于1的自然数n，若n为奇数，则将n变为3n+1,否则变为n的一半。经过若干次这样的变换，一定会使n变为1.
     * 输入n,输出变换的次数
     * 例题2-2
     * 注意乘法溢出
     */
    public void example2_2() {
        System.out.print("请输入一个大于1的自然数：");
        Scanner in = new Scanner(System.in);
        long a = in.nextInt();
        int count = 0;
        while (a > 1) {
            if (a % 2 == 1) a = 3 * a + 1;
            else a /= 2;
            count++;
        }

        System.out.println("次数：" + count);
    }

    /**
     * 题目：计算π/4=1-1/3+1/5-1/7+...，直到最后一项小于10的-6次方
     */
    public void exapmle2_3() {
        double sum = 0;
        for (int i = 0; ; i++) {
            double temp = 1.0 / (i * 2 + 1);
            if (i % 2 == 0) sum += temp;
            else sum -= temp;
            if (temp < Math.pow(10, -6)) break;
        }
        System.out.println("sum:" + sum);
    }

    /**
     * 题目：阶乘之和，输入n，计算S=1!+2!+3!+.....+n!的末6位。n≤10的六次方
     */
    public void example2_4() {
        System.out.println("请输入整数n:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long S = 0;
        long result = 0;
        for (int i = 1; i <= n; i++) {
            int temp = 1;
            for (int j = 1; j <= i; j++) {
                temp *= j;
            }
            S += temp;
        }
        result = S % 1000000;
        System.out.println(S);
        System.out.println("后六位为：" + result);
    }

    /**
     * 习题2-1：输出100~999中的所有水仙花数。若3位数ABC满足...
     * P34
     */
    public void exercises2_1() {
        for (int i = 100; i < 999; i++) {
            int A = i / 100;
            int B = (i / 10) % 10;
            int C = i % 10;
            if (i == (int) (Math.pow(A, 3) + Math.pow(B, 3) + Math.pow(C, 3))) {
                System.out.println("水仙花数：" + i);
            }
        }
    }

    /**
     * 习题2-2：韩信点兵
     * P34
     */
    public void exercises2_2() {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入数据1：");
        int a = in.nextInt();
        System.out.print("请输入数据2：");
        int b = in.nextInt();
        System.out.print("请输入数据3：");
        int c = in.nextInt();

        boolean result = false;

        for (int x = 10; x < 100; x++) {
            if (x % 3 == a && x % 5 == b && x % 7 == c) {
                System.out.println("总人数：" + x);
                result = true;
            }
        }

        if (!result) System.out.println("No answer.");
    }

    /**
     * 习题2-3：倒三角形问题
     * P34
     */
    public void exercises2_3() {
        Scanner in = new Scanner(System.in);
        int n = 0;
        System.out.print("请输入三角形层数(小于20)：");
        n = in.nextInt();
        if (n > 0 && n < 20) {
            int k = 0;//表示第几层
            for (; n > 0; n--) {
                k++;
                for (int m = 0; m < k - 1; m++) {
                    System.out.print(" ");
                }
                for (int i = 0; i < (2 * n - 1); i++) {
                    if (i < (2 * n - 2)) {
                        System.out.print("*");
                    } else {
                        System.out.println("*");
                    }
                }
            }
        } else {
            System.out.println("输入非法！请重新输入!");
            exercises2_3();
        }
    }

    /**
     * 习题2-4：子序列的和
     * P35
     */
    public void exercises2_4() {
        Scanner in = new Scanner(System.in);

        System.out.print("请输入第一个数：");
        int n = in.nextInt();
        System.out.print("请输入第二个数：");
        int m = in.nextInt();
        double sum = 0;

        if (n < m && n < 1000000 && m < 1000000) {
            for (; n <= m; n++) {
                sum += 1 / (Math.pow(n, 2));
            }
            System.out.printf("%.5f", sum);
        } else {
            System.out.println("输入有误，请重写输入！");
            exercises2_4();
        }
    }

    /**
     * 习题2-5：分数化小数
     * P35
     */
    public void exercises2_5() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        double a = in.nextInt();
        System.out.println("请输入第二个数：");
        double b = in.nextInt();
        System.out.println("请输入第三个数：");
        int c = in.nextInt();

        if (a < 1000000 && b < 1000000 && c < 100) {
            double result = a / b;
            String temp = "%." + c + "f";
            System.out.printf(temp, result);
        }
    }

    /**
     * 习题2-6：排列
     * 用1,2,3……,9组成3个三位数abc,def和ghi,每个数字恰好使用一次,要求abc:def:ghi=1:2:3.输出所有解。
     * P35
     */
    public void exercises2_6() {

        int i, j, k;
        int result_add, result_mul;

        for (i = 123; i < 329; i++) {
            j = i * 2;
            k = i * 3;
            result_add = 0;
            result_mul = 1;

            int[] array1 = result(i, result_add, result_mul);
            int[] array2 = result(j, result_add, result_mul);
            int[] array3 = result(k, result_add, result_mul);

            if (array1[0] + array2[0] + array3[0] == 45 && array1[1] * array2[1] * array3[1] == 362880) {
                System.out.println(i + " " + j + " " + k);
            }
        }
    }

    int[] result(int num, int result_add, int result_mul) {
        int i = num / 100;
        int j = num / 10 % 10;
        int k = num % 10;

        result_add += i + j + k;
        result_mul *= i * j * k;

        return new int[]{result_add, result_mul};
    }
}
