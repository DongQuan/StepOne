package jxuan95.java;

import jdk.nashorn.internal.ir.BinaryNode;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * Created by jxuan on 16-3-19.
 * 算法
 */
public class Arithmetic_Sort2 {

    public static void insertSort(int[] args) {
        int temp;
        for (int i = 1; i < args.length; i++) {
            temp = args[i];
            int j = i - 1;
            for (; j >= 0 && args[j] > temp; j--) {
                args[j + 1] = args[j];
            }
            args[j + 1] = temp;
        }

        for (int test : args) {
            System.out.println(test);
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int t : array) {
            System.out.println(t);
        }
    }

    /**
     * 简单选择排序
     *
     * @param a 传入一个数组
     */
    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int temp;
                if (a[j] < a[i]) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }

        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void shellSort(int[] a) {

    }

    /**
     * 归并
     */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        internalMergeSort(arr, temp, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void internalMergeSort(int[] a, int[] b, int left, int right) {
        //当left==right的时，已经不需要再划分了
        if (left < right) {
            int middle = (left + right) / 2;
            internalMergeSort(a, b, left, middle);          //左子数组
            internalMergeSort(a, b, middle + 1, right);       //右子数组
            mergeSortedArray(a, b, left, middle, right);    //合并两个子数组
        }
    }

    // 合并两个有序子序列 arr[left, ..., middle] 和 arr[middle+1, ..., right]。temp是辅助数组。
    private static void mergeSortedArray(int arr[], int temp[], int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= middle) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = 0; i < k; i++) {
            arr[left + i] = temp[i];
        }
    }

    public static void testFor(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
