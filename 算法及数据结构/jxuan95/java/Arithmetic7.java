package jxuan95.java;

/**
 * Created by jxuan on 16-3-25.
 * 算法
 */
public class Arithmetic7 {
    public static void main(String[] args) {

        int[] orderlyArray = new int[]{1, 2, 5, 8, 9, 77, 111, 333, 555, 666};
//        System.out.println(BinSearch(orderlyArray, 0, orderlyArray.length, 9));

        int[] a = new int[]{2, 2, 1, 2, 2, 2};
        int[] b = new int[]{};
        System.out.println(minNumberInRotateArray(b));
    }

    //二分查找
    public static int BinSearch(int[] array, int left, int right, int key) {
        if (left <= right) {
            int mid = (left + right) >> 1;
            if (key == array[mid]) {
                return mid;
            } else if (key <= array[mid]) {
                return BinSearch(array, left, mid - 1, key);
            } else if (key > array[mid]) {
                return BinSearch(array, mid + 1, right, key);
            }
        }
        return -1;
    }

    //旋转数组的最小数字
    public static int minNumberInRotateArray(int[] array) {
        int length = array.length;
        if (length != 0) {
            int minNum = array[0];
            for (int i = 0; i < length; i++) {
                if (array[i] <= minNum) {
                    minNum = array[i];
                }
            }

            return minNum;
        } else {
            return 0;
        }

    }

}
