package com.springmvc.algo;/**
 * Created by yanrupeng on 2018/3/29.
 */


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: springdemo
 * User: yanrupeng
 * Date: 2018/3/29
 * Time: 21:39
 * To change this template use File | Settings | File and Code Templates.
 */
public class Chain {
    @Test
    public void testReverseChainM1() {
        System.out.println("Test ReverseChainM1 start");
        long startTime = System.currentTimeMillis();
        Chain chain = new Chain();
        System.out.println("------0个元素--------");
        //0个元素
        ChainData head0 = null;
        chain.printChain(head0);
        head0 = reverseChainM1(head0);
        chain.printChain(head0);
        System.out.println("------1个元素--------");
        //1个元素
        ChainData head1 = chain.new ChainData("A");
        head1.next = null;
        head1.prev = null;
        chain.printChain(head1);
        head1 = reverseChainM1(head1);
        chain.printChain(head1);
        System.out.println("------2个元素--------");
        //2个元素
        ChainData head2 = chain.new ChainData("A");
        ChainData c21 = chain.new ChainData("B");
        head2.prev = null;
        head2.next = c21;
        c21.prev=head2;
        c21.next = null;
        chain.printChain(head2);
        head2 = reverseChainM1(head2);
        chain.printChain(head2);
        System.out.println("------多于2个元素--------");
        //多于2个元素
        ChainData head3 = chain.new ChainData("A");
        ChainData c31 = chain.new ChainData("B");
        ChainData c32 = chain.new ChainData("C");
        ChainData c33 = chain.new ChainData("D");
        head3.prev = null;
        head3.next = c31;
        c31.prev = head3;
        c31.next = c32;
        c32.prev = c31;
        c32.next = c33;
        c33.prev = c32;
        c33.next = null;
        chain.printChain(head3);
        head3 = reverseChainM1(head3);
        chain.printChain(head3);
        System.out.println("Test ReverseChainM1 end !  used:" + (System.currentTimeMillis()-startTime) + "ms");

    }
    @Test
    public void testReverseChainM2() {
        System.out.println("Test ReverseChainM2 start");
        long startTime = System.currentTimeMillis();
        Chain chain = new Chain();
        System.out.println("------0个元素--------");
        //0个元素
        ChainData head0 = null;
        chain.printChain(head0);
        head0 = reverseChainM2(head0);
        chain.printChain(head0);
        System.out.println("------1个元素--------");
        //1个元素
        ChainData head1 = chain.new ChainData("A");
        head1.next = null;
        head1.prev = null;
        chain.printChain(head1);
        head1 = reverseChainM2(head1);
        chain.printChain(head1);
        System.out.println("------2个元素--------");
        //2个元素
        ChainData head2 = chain.new ChainData("A");
        ChainData c21 = chain.new ChainData("B");
        head2.prev = null;
        head2.next = c21;
        c21.prev=head2;
        c21.next = null;
        chain.printChain(head2);
        head2 = reverseChainM2(head2);
        chain.printChain(head2);
        System.out.println("------多于2个元素--------");
        //多于2个元素
        ChainData head3 = chain.new ChainData("A");
        ChainData c31 = chain.new ChainData("B");
        ChainData c32 = chain.new ChainData("C");
        ChainData c33 = chain.new ChainData("D");
        head3.prev = null;
        head3.next = c31;
        c31.prev = head3;
        c31.next = c32;
        c32.prev = c31;
        c32.next = c33;
        c33.prev = c32;
        c33.next = null;
        chain.printChain(head3);
        head3 = reverseChainM2(head3);
        chain.printChain(head3);
        System.out.println("Test ReverseChainM2 end !  used:" + (System.currentTimeMillis()-startTime) + "ms");
    }

    /**
     * 翻转双向链表（方法2）
     * 元素的next和prev交换
     *
     * @param chain
     * @return
     */
    public ChainData reverseChainM2(ChainData chain) {
        if (chain == null || !chain.hasNext()) {
            return chain;
        }
        ChainData nextData;
        ChainData prevData = null;
        while (chain.hasNext()) {
            nextData = chain.next;
            chain.next = chain.prev;
            chain.prev = nextData;
            prevData = chain;
            chain = nextData;
        }
        chain.next = prevData;
        chain.prev = null;
        return chain;
    }

    /**
     * 翻转双向链表 方法1
     * 元素放入list，重构链表
     *
     * @param chain
     * @return
     */
    public ChainData reverseChainM1(ChainData chain) {
        if (chain == null || !chain.hasNext()) {
            return chain;
        }
        List<ChainData> list = new ArrayList<>();
        list.add(chain);
        while (chain.hasNext()) {
            list.add(chain.next);
            chain = chain.next;
        }
        list.get(0).next = null;
        list.get(0).prev = list.get(1);
        for (int i = 1; i < list.size() - 1; ++i) {
            list.get(i).next = list.get(i - 1);
            list.get(i).prev = list.get(i + 1);
        }
        list.get(list.size() - 1).prev = null;
        list.get(list.size() - 1).next = list.get(list.size() - 2);
        return list.get(list.size() - 1);
    }

    /**
     * 打印链表
     *
     * @param chain
     */

    public void printChain(ChainData chain) {
        if (chain == null) {
            System.out.println("empty chain");
            return;
        }
        ChainData nextChain = chain;
        StringBuilder sb = new StringBuilder();
        sb.append(nextChain);
        while (nextChain.hasNext()) {
            nextChain = nextChain.next;
            sb.append("->").append(nextChain);
        }
        System.out.println(sb.toString());
    }

    /**
     * 链表元素
     */
    class ChainData {
        private ChainData next;
        private ChainData prev;
        private String data;

        public ChainData(String str) {
            this.data = str;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        @Override
        public String toString() {
            return data;
        }
    }
}


