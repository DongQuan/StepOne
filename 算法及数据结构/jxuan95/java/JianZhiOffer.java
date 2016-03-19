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

    /**
     * 用两个栈实现队列
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 1.假设当有n个台阶时假设有f(n)种走法。
     * 2.青蛙最后一步要么跨1个台阶要么跨2个台阶。
     * 3.当最后一步跨1个台阶时即之前有n-1个台阶，根据1的假设即n-1个台阶有f(n-1)种走法。
     * 4. 当最后一步跨1个台阶时即之前有n-2个台阶，根据1的假设即n-2个台阶有f(n-2 )种走法。
     * 5.显然n个台阶的走法等于前两种情况的走法之和即f(n)=f(n-1)+f(n-2)。
     * 6.找出递推公式后要找公式出口，即当n为1、2时的情况，显然n=1时f(1)等于1，f(2)等于2
     * 7.         | 1, (n=1)
     * f(n) =  |2, (n=2)
     * | f(n-1)+f(n-2) ,(n>2,n为整数)
     */
    public static int JumpFloor(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }


    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
     * @param n 传入n
     * @return 返回第n项
     */
    public static int Fibonacci(int n) {
        int[] a = new int[n + 1];

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        a[0] = 0;
        a[1] = 1;
        for (int i = 1; i + 1 <= n; i++) {
            a[i + 1] = a[i - 1] + a[i];
        }


        return a[n];

    }
}
