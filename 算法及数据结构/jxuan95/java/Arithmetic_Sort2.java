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

    public static void quickSort(int[] a, int start, int end) {

        if (start < end) {
            int i = start;
            int j = end;
            int temp = a[start];

            while (i < j) {
                while (i < j && a[j] >= temp) {
                    j--;
                }
                if (i < j) {
                    a[i] = a[j];
                    i++;
                }
                while (i < j && a[i] <= temp) {
                    i++;
                }
                if (i < j) {
                    a[j] = a[i];
                    j--;
                }
            }
            a[i] = temp;

            quickSort(a, start, i - 1);
            quickSort(a, i + 1, end);
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 计数排序算法
     * 找出待排序的数组中最大和最小的元素
     * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项
     * 对所有的计数累加（从C中的位置为1的元素开始，每一项和前一项相加）
     * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1
     */
    public static void countSort(int[] a) {
        int maxNum = 0, sum = 0;

        for (int k : a) {
            if (k > maxNum) {
                maxNum = k;
            }
        }

        int[] c = new int[maxNum + 1];
        int[] b = new int[a.length];

        for (int i : a) {
            c[i] += 1;
        }

        for (int j = 0; j < c.length; j++) {
            sum = sum + c[j];
            c[j] = sum;
        }

        for (int t = a.length - 1; t >= 0; t--) {
            b[c[a[t]] - 1] = a[t];
            c[a[t]]--;
        }
        System.out.println(Arrays.toString(b));
    }

    /**
     * 桶排序
     */
    public static void bucketSort(int[] a) {
        int max = 0;
        int length = a.length;
        int m = 0;
        int[] array = new int[length];

        for (int i : a) {
            if (i > max) max = i;
        }

        int[] bucket = new int[2*max];

        //开头为零和重复数据都可以完美排序
        for (int i = 0; i < length; i++) {
            if (a[i] == 0) {
                array[m] = 0;
                m++;
            } else if (bucket[a[i]] == a[i]) {
                for (int j = i; j < length; j++) {
                    bucket[a[j] + 2] = bucket[a[j] + 1];
                }
                bucket[a[i] + 1] = a[i];
            } else {
                bucket[a[i]] = a[i];
            }
        }
        System.out.println(Arrays.toString(bucket));
        if (m < length)
            for (int k = 0; k < bucket.length; k++) {
                if (bucket[k] != 0) {
                    array[m++] = bucket[k];
                }
            }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(array));
    }
}
