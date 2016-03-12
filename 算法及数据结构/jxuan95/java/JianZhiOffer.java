package jxuan95.java;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.lang.*;

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
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    /**
     * 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */
}
