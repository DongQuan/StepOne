package jxuan95.java;

/**
 * Created by jxuan on 16-2-20.
 * 算法20160220
 */
public class Arithmetic20160220 {

    /**
     * 直接插入排序
     * 基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排
     * 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
     * 也是排好顺序的。如此反复循环，直到全部排好顺序。
     */
    public void insertSort() {
        int[] array = new int[]{57, 68, 59, 62, 5, 106, 20, 17, 3, 968};
        int temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j = i - 1;
            for (; j >= 0 && temp < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }

        for (int m : array) {
            System.out.println(m);
        }
    }

    /**
     * 简单选择排序
     * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     */
    public void selectSort() {
        int[] array = new int[]{57, 68, 59, 62, 5, 106, 20, 17, 3, 968};
        int temp;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            int j = i + 1;
            for (; j < array.length; j++) {
                if (array[j] < array[i]) {
                    array[i] = array[j];
                    array[j] = temp;
                    temp = array[i];
                }
            }
        }

        for (int i : array) {
            System.out.println(i);
        }
    }
}
