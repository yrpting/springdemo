package com.springmvc.algo.tree;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

public class Bfs {
    private static final Logger logger = LoggerFactory.getLogger(Bfs.class);

    @Test
    public void bfs() {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        head.left = n2;
        head.right = n3;
        n2.left = n4;
        n4.right = n12;
        n3.left = n9;
        n3.right = n11;
        n9.right = n10;
        logger.info("tree:{}", head);
//        printLayerLast1(head);
        printLayerFirst(head);
        printLayerLast(head);
    }

    /**
     * 不知道为啥对
     * @param head
     */
//    private void printLayerLast1(Node head) {
//        logger.info("print layer first start1");
//        LinkedList<Node> queue = new LinkedList<>();
//        queue.offer(head);
//        int temp = 1;
//        int nextLayerCount = 0;
//        while (queue.size() > 0) {
//            Node node = queue.poll();
//            temp--;
//
//            if (node.left != null) {
//                queue.offer(node.left);
//                nextLayerCount += 1;
//            }
//            if (node.right != null) {
//                queue.offer(node.right);
//                nextLayerCount += 1;
//            }
//            if (temp == 0) {
//                logger.info("{}\n", node.value);
//                temp = nextLayerCount;
//                nextLayerCount = 0;
//            }
//        }
//        logger.info("print layer first end1");
//    }

    private void printLayerFirst(Node head) {
        logger.info("print layer first start");
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(head);
        int currentLayerCount = 1;
        int temp = 0;
        int nextLayerCount = 0;
        while (queue.size() > 0) {
            Node node = queue.poll();
            temp++;
            if (node.right != null) {
                queue.offer(node.right);
                nextLayerCount += 1;
            }
            if (node.left != null) {
                queue.offer(node.left);
                nextLayerCount += 1;
            }
            if (temp == currentLayerCount) {
                logger.info("{}\n", node.value);
                currentLayerCount = nextLayerCount;
                nextLayerCount = 0;
                temp = 0;
            }
        }
        logger.info("print layer first end");

    }


    private void printLayerLast(Node head) {
        logger.info("print layer last start");
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(head);
        int currentLayerCount = 1;
        int temp = 0;
        int nextLayerCount = 0;
        while (queue.size() > 0) {

            Node node = queue.poll();
            if (temp == 0) {
                logger.info("left {} ", node.value);
            }
            temp++;
            if (node.left != null) {
                queue.offer(node.left);
                nextLayerCount += 1;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLayerCount += 1;
            }
            if (temp == currentLayerCount) {
                logger.info("right {}\n", node.value);
                currentLayerCount = nextLayerCount;
                nextLayerCount = 0;
                temp = 0;
            }

        }
        logger.info("print layer last end");
    }

    class Node {
        private int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
