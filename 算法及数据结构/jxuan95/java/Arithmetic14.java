package jxuan95.java;

/**
 * Created by jxuan on 16-3-28.
 * 算法
 */
public class Arithmetic14 {
    public static void main(String[] args) {
        ListNode t1 = new ListNode(111);
        System.out.println(t1);
        int i = 1;
        if (i == 0) {
            t1.next = new ListNode(112);
            t1 = t1.next;
            System.out.println(t1);
        } else {
            ListNode t2 = t1;
            t2.next = new ListNode(113);
            t2 = t2.next;
            System.out.println("t1:" + t1);
            System.out.println("t2:" + t2);
        }

    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
