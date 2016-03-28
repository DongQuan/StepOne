package jxuan95.java;

import java.util.List;

/**
 * Created by jxuan on 16-3-28.
 * 算法
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class Arithmetic12 {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(9);
        System.out.println(ReverseList(head));
    }

    public static ListNode ReverseList(ListNode head) {

        if (head == null) return null;

        ListNode preNode = null;
        ListNode nextNode = head.next;
        ListNode inNode = head;

        head.next = null;
        preNode = head;

        head = nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }

        return preNode;

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

    public static ListNode ReverseList2(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
