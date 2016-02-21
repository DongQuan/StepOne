package jxuan95.java;

/**
 * Created by jxuan on 16-2-20.
 * 测试用
 */
public class Main {

    public static void main(String[] args){

        int[] a = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5,
                4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

        Arithmetic arithmetic = new Arithmetic();
//        arithmetic.insertSort();
//        arithmetic.selectSort();
//        arithmetic.bubbleSort();
//        arithmetic.shellSort();
        arithmetic.quickSort();
    }
}
