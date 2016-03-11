package jxuan95.java;

/**
 * Created by jxuan on 16-3-11.
 * 牛客网剑指offer习题
 */
public class JianZhiOffer {

    /**
     * 二维数组中的查找
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public boolean Find(int[][] array, int target) {
        int row = array.length;
        int list = array[0].length;
        int i = 0;
        while (i < row) {
            for (int j = 0; j < list; j++) {
                if(array[i][j]==target){
                    System.out.println(array[i][j]);
                    return true;
                }
            }
            i++;
        }
        return false;
    }
}
