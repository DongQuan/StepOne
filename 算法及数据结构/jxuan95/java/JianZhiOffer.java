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
                if (array[i][j] == target) {
                    System.out.println(array[i][j]);
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    /**
     * 替换空格
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public String replaceSpace(StringBuffer str) {
        int length = str.length();
        String string = "";
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                string += "%20";
            } else {
                string += str.charAt(i);
            }
        }
        System.out.println(string);
        return string;
    }

    /**
     * 输入一个链表，从尾到头打印链表每个节点的值。
     */
    
}
