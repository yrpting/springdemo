package com.springdemo.test.algorithm;

public class MaxSubArrSum {
    public static void main(String[] args) {
        int[] a = { 1, -2, 3, 10, -4, 7, 2, -5 };
        System.out.println(maxSum(a));
    }

    private static int maxSum(int[] a) {
        int sum = 0;
        int c = 0;
        String str = "";
        for (int i = 0; i < a.length; ++i) {
            if (c < 0) {
                c = a[i];
                str = c+"";
            } else {
                str +=" "+a[i];
                c += a[i];
            }
            if (sum < c) {
                sum = c;
            }
        }
        System.out.println(str);
        return sum;
    }
}
