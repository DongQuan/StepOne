package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-3-30.
 * 输入一个百分制的成绩t，将其转换成对应的等级，具体转换规则如下：
 * 90~100为A;
 * 80~89为B;
 * 70~79为C;
 * 60~69为D;
 * 0~59为E;
 */
public class P2004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n >= 0 && n <= 100) {
                if (n >= 90 && n <= 100) {
                    System.out.println("A");
                } else if (n >= 80 && n <= 89) {
                    System.out.println("B");
                } else if (n >= 70 && n <= 79) {
                    System.out.println("C");
                } else if (n >= 60 && n <= 69) {
                    System.out.println("D");
                } else if (n >= 0 && n <= 59) {
                    System.out.println("E");
                }
            } else {
                System.out.println("Score is error!");
            }
        }
    }
}
