package jxuan95;

import java.util.Scanner;

/**
 * Created by eisen on 16-9-5.
 * 题目描述：
 * 尽管是一个CS专业的学生，小B的数学基础很好并对数值计算有着特别的兴趣，喜欢用计算机程序来解决数学问题。
 * 现在，她正在玩一个数值变换的游戏。她发现计算机中经常用不同的进制表示同一个数，如十进制数123表达为16进制时只包含两位数7、11（B）
 * ，用八进制表示时为三位数1、7、3。按不同进制表达时，各个位数的和也不同，如上述例子中十六进制和八进制中各位数的和分别是18和11。
 * 小B感兴趣的是，一个数A如果按2到A-1进制表达时，各个位数之和的均值是多少？她希望你能帮她解决这个问题？
 * 所有的计算均基于十进制进行，结果也用十进制表示为不可约简的分数形式。
 */
public class JDXiaozhao1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String nBin = Integer.toString(n, 2);
            int len = nBin.length();
            int[] array = new int[len];
            for (int j = 2; j < n - 1; j++) {
                for (int k = 0; k < Integer.toString(n, j).length(); k++) {
                    array[k] += Integer.parseInt(String.valueOf(Integer.toString(n, j).charAt(k)));
                }
            }
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            System.out.println(sum / len);
        }
    }
}
