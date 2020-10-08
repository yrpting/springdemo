package com.springmvc.algo.chain;

public class ChainReverse {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node first = new Node(2);
        Node second = new Node(3);
        head.next= first;
        first.next = second;
        second.next = new Node(4);
        System.out.println(head);
        System.out.println(revert(head));

    }

    private static Node revert(Node head) {
        if(head == null|| head.next == null){
            return head;
        }
        Node pre  = null;
        Node current = head;
        Node temp ;
        while (current.next != null){
            temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        current.next = pre;
        return current;
    }

    private static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

}
