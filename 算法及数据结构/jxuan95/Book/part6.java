package jxuan95.Book;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by jxuan on 16-4-15.
 * 进军硅谷
 */
public class part6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int sum = in.nextInt();
            int[] a = new int[]{1, 5, 7, 3};
            int i = 0, j = a.length - 1;
            while (i < j) {
                if (a[i] + a[j] == sum) {
                    System.out.println(a[i] + "+" + a[j] + "=" + sum);
                    break;
                } else if (a[i] + a[j] > sum) {
                    j--;
                } else {
                    i++;
                }
            }
        }
    }

    public static int[] twoSum(int[] A, int target) {
        int[] res = {-1, -1};
        if (A == null || A.length < 2) {
            return res;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            //扫描一遍，存储值和下标
            hm.put(A[i], i);
        }

        for (int i = 0; i < A.length; i++) {
            if (hm.containsKey(target - A[i]) && target != 2 * A[i]) {
                //获取结果的两个下标
                res[0] = i;
                res[1] = hm.get(target - A[i]);
            }
        }
        return res;
    }

    public class TwoSum {
        HashMap<Integer, Integer> hm = new HashMap<>();

        public void save(int input) {
            int originalCount = 0;
            if (hm.containsKey(input)) {
                //判断是否已经存在，如果存在，则读取个数
                originalCount = hm.get(input);
            }
            hm.put(input, originalCount + 1);
        }

        public boolean test(int target) {
            Iterator<Integer> it = hm.keySet().iterator();
            while (it.hasNext()) {
                int value = it.next();
                if (hm.containsKey(target - value)) {
                    //需要判断一下是否有这种特殊情况
                    boolean isDouble = target == value * 2;
                    if (!(isDouble && hm.get(value) == 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}