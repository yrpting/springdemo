package com.springmvc.algo.chain;

import java.util.List;

public class TwoSum {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        TwoSum twoSum = new TwoSum();
        ListNode node = twoSum.addTwoNumbers(l1,l2);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(node);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode current = preHead;
        int up = 0;
        while(l1 != null || l2 != null){
            int sum = 0;
            if(l1 == null){
                sum = l2.val + up;
                up = sum /10;
                current.next = new ListNode(sum %10);
                current = current.next;
                l2 = l2.next;
                continue;
            }
            if(l2 == null){
                sum = l1.val + up;
                up = sum /10;
                current.next = new ListNode(sum %10);
                current = current.next;
                l1 = l1.next;
                continue;
            }
            sum = l1.val + l2.val + up;
            up = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(up>0){
            current.next = new ListNode(up);
        }
        return preHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
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

