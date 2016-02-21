package jxuan95.java;

import java.util.Arrays;

/**
 * Created by jxuan on 16-2-20.
 * 算法20160220
 */
public class Arithmetic {

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

    /**
     * 冒泡排序
     * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，
     * 让较大的数往下沉，较小的往上冒。
     * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     */
    public void bubbleSort() {
        int[] array = new int[]{57, 68, 59, 62, 5, 106, 20, 17, 3, 968};
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 希尔排序
     * 希尔排序(缩小增量法) 属于插入类排序,由Shell提出，
     * 希尔排序对直接插入排序进行了简单的改进：它通过加大插入排序中元素之间的间隔，
     * 并在这些有间隔的元素中进行插入排序，从而使数据项大跨度地移动，
     * 当这些数据项排过一趟序之后，希尔排序算法减小数据项的间隔再进行排序，依次进行下去，
     * 进行这些排序时的数据项之间的间隔被称为增量，习惯上用字母h来表示这个增量。
     */
    public void shellSort() {

    }

    /**
     * 快速排序
     * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
     * 则分别对这两部分继续进行排序，直到整个序列有序。
     */
    public void quickSort(int[] a, int start, int end) {
        // 设置关键数据key为要排序数组的第一个元素，
        // 即第一趟排序后，key右边的数全部比key大，key左边的数全部比key小
        int key = a[start];
        // 设置数组左边的索引，往右移动比key大的数
        int i = start;
        // 设置数组右边的索引，往左移动比key小的数
        int j = end;

        // 如果左边索引比右边索引小，则还有数据没有排序
        while (i < j) {
            while (a[j] > key && j > i) {
                j--;
            }
            a[i] = a[j];

            while (a[i] < key && i < j) {
                i++;
            }
            a[j] = a[i];
        }
        // 此时 i==j
        a[i] = key;

        // 递归调用
        if (i - 1 > start) {
            // 递归调用，把key前面的完成排序
            quickSort(a, start, i - 1);
        }
        if (i + 1 < end) {
            // 递归调用，把key后面的完成排序
            quickSort(a, i + 1, end);
        }
    }

}
