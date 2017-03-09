package com.springdemo.test.algorithm;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { 2,1,234,2,3,2,2,1 };
        sort(arr);
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
        for(Integer i:arr){
            System.out.print(i+" ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low>=high) return;
        int X = arr[low];
        int i = low, j = high;
        while (i < j) {
            while (i < j && arr[j] > X)
                j--;
            arr[i] = arr[j];
            while (i < j && arr[i] <= X)
                i++;
            arr[j] = arr[i];
        }
        arr[i]=X;
        quickSort(arr,low,i-1);
        quickSort(arr,i+1,high);
    }

}
