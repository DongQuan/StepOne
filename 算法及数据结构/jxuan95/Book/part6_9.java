package jxuan95.Book;

/**
 * Created by jxuan on 16-4-16.
 * 数组配对
 */
public class part6_9 {
    public static void main(String[] args) {

    }

    public boolean checkPairable(int[] nums, int k) {
        if (k <= 0) {
            return false;
        }

        //额外数组保存余数情况
        int[] counts = new int[k];
        for (int num : nums) {
            //初始化余数数组
            counts[num % k]++;//counts[0]表示余数为0的个数
        }

        //整除k的个数若不是偶数，返回false
        if (counts[0] % 2 != 0) {
            return false;
        }

        //k是偶数时，查看余数k/2的个数是否为偶数
        if (k % 2 == 0) {
            if (counts[k / 2] % 2 != 0) {
                return false;
            }
        }

        for (int i = 1; i <= k / 2; i++) {
            //余数配对
            if (counts[i] != counts[k - i]) {
                return false;
            }
        }
        return true;
    }
}
