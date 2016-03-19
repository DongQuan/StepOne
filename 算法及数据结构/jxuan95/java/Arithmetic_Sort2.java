package jxuan95.java;

import jdk.nashorn.internal.ir.BinaryNode;

import javax.swing.tree.TreeNode;

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
}
