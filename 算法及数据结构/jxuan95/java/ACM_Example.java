package jxuan95.java;

/**
 * Created by jxuan on 16-2-24.
 * 《算法竞赛入门经典第二版》
 */
public class ACM_Example {

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
}
