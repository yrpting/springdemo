package com.springdemo.test.algorithm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * 包含min函数的栈
 *       min push pop时间复杂度均为O(1),但目前不是线程安全的。
 *       利用空间复杂度来代替时间复杂度。 
 * @Filename: MinStack.java
 * @Version: 1.0
 * @Author: yanrp 燕如朋
 * @Email: 
 *
 */
public class MinStack<T extends Comparable<T>> {
    /**
     * 存放栈数据的list
     */
    private List<T> values;
    /**
     * 存放最小元素的list
     */
    private List<T> minValues;

    /**
     * 当push时，如果minValues中的栈顶元素大于加入的元素，则该元素加入minValues，否则只加入values
     * @param val
     * @return
     */
    public boolean push(T val) {
        if (values == null)
            values = new ArrayList<>();
        if (minValues == null)
            minValues = new ArrayList<>();
        if (minValues.size() <= 0 || minValues.get(minValues.size() - 1).compareTo(val) > 0)
            minValues.add(val);
        return values.add(val);
    }

    /**
     * 和push相反，如果minValues中的栈顶元素和values的栈顶元素相同，则minValues也弹出该元素，否则只弹出values栈顶元素
     * @return
     */
    public T pop() {
        T val = values.remove(values.size() - 1);
        if (minValues != null && minValues.get(minValues.size() - 1).compareTo(val) == 0)
            minValues.remove(minValues.size() - 1);
        return val;
    }
/**
 * 
 * @return
 */
    public T min() {
        return minValues == null || minValues.size() <= 0 ? null
            : minValues.get(minValues.size() - 1);
    }
}

class TestStack {
    public static void main(String[] args) {
        MinStack<Integer> ms = new MinStack<>();
        ms.push(12);
        ms.push(3);
        ms.push(1);
        ms.push(4);
        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());
    }
}
