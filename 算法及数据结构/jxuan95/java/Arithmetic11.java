package jxuan95.java;

/**
 * Created by jxuan on 16-3-28.
 * 算法
 * 剑指offer 求出链表倒数第k个节点
 */
public class Arithmetic11 {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println(FindKthToTail(head,3));
    }


    public static ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }
        ListNode pre = head;
        ListNode last = head;
        for(int i = 1; i < k; i++) {
            if(pre.next != null) {
                pre = pre.next;
            } else {
                return null;
            }
        }

        while(pre.next!=null) {
            pre = pre.next;
            last = last.next;
        }

        return last;
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
