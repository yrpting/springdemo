package com.springdemo.test;

class A {
    int i;
}

public class Island extends A {
    private static int[][] a = { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 1, 1 } };

    private static int     m = 3, n = 3;

    public static void main(String[] args) {
        printA();
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (a[i][j] == 1) {
                    cnt += 1;
                    findWay(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    private static void findWay(int i, int j) {
        a[i][j] = 0;
        // printA();
        if (i - 1 >= 0 && a[i - 1][j] == 1)
            findWay(i - 1, j);
        if (i + 1 < m && a[i + 1][j] == 1)
            findWay(i + 1, j);
        if (j - 1 >= 0 && a[i][j - 1] == 1)
            findWay(i, j - 1);
        if (j + 1 < n && a[i][j + 1] == 1)
            findWay(i, j + 1);
    }

    private static void printA() {
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }

}
