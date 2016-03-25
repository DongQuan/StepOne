package jxuan95.java;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jxuan on 16-3-25.
 * 算法
 */
public class Arithmetic10 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        reOrderArray(a);
    }

    public static void reOrderArray(int[] array) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                b.add(array[i]);
            } else {
                a.add(array[i]);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(a);
        list.addAll(b);

        for (int j = 0; j < array.length; j++) {
            if (j < a.size()) {
                array[j] = a.get(j);
            } else {
                array[j] = b.get(j - a.size());
            }
        }

        System.out.println(Arrays.toString(array));

    }
}
