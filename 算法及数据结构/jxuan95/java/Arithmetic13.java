package jxuan95.java;

import java.util.List;

/**
 * Created by jxuan on 16-3-28.
 * 剑指offer算法合并链表
 */
public class Arithmetic13 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(9);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(5);

//        System.out.println(Merge(list1, list2));
        System.out.println(Merge3(list1, list2));
    }


    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode result = null;

        if (list1.val <= list2.val) {
            result = list1;
            list1 = list1.next;
        } else {
            result = list2;
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                result.next = list1;
                list1 = list1.next;
                result = result.next;
            } else {
                result.next = list2;
                list2 = list2.next;
                result = result.next;
            }
        }

        while (list1 != null || list2 != null) {
            if (list1 == null && list2 != null) {
                result.next = list2;
                list2 = list2.next;
                result = result.next;
            }

            if (list1 != null && list2 == null) {
                result.next = list1;
                list1 = list1.next;
                result = result.next;
            }

        }
        return result;
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

    public static ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode mergeNode = null;
        if (list1.val < list2.val) {
            mergeNode = list1;
            mergeNode.next = Merge2(list1.next, list2);
        } else {
            mergeNode = list2;
            mergeNode.next = Merge2(list1, list2.next);
        }

        return mergeNode;
    }

    public static ListNode Merge3(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode head = null;
        ListNode tmp = null;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        tmp = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {

                tmp.next = list1;
                list1 = list1.next;
                tmp = tmp.next;

            } else {
                tmp.next = list2;
                list2 = list2.next;
                tmp = tmp.next;
            }
        }

        while (list1 != null || list2 != null) {
            if (list1 == null && list2 != null) {
                tmp.next = list2;
                list2 = list2.next;
                tmp = tmp.next;
            }

            if (list2 == null && list1 != null) {
                tmp.next = list1;
                list1 = list1.next;
                tmp = tmp.next;
            }
        }
        return head;
    }
}
