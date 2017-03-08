package com.springdemo.test;

/**
 * 将26个字母按顺时针方向将数组填充
 * eg1: 3 * 3
 *    a b c 
 *    h i d 
 *    g f e 
 * eg2: 2 * 4
 *    a b c d 
 *    h g f e 
 *                       
 * @Filename: FillArrays.java
 * @Version: 1.0
 * @Author: yanrp 燕如朋
 * @Email: 
 *
 */
public class FillArrays {
    private static final String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                                            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                                            "w", "x", "y", "z" };

    public static void main(String[] args) {
        int row = 5, col = 5;
        String[][] arr = fillArray(row, col);

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    private static String[][] fillArray(int row, int col) {
        String[][] arr = new String[row][col];
        int charsNum = 0;
        int left = 0, top = 0, right = col - 1, bottom = row - 1;
        Direct direct = Direct.RIGHT;
        int i = 0, j = 0;
        int k = 0;
        while (k++ < row * col) {

            arr[i][j] = chars[charsNum++ % (chars.length)].toUpperCase();
            switch (direct) {
                case RIGHT:
                    if (j == right) {
                        i++;
                        top = i;
                        direct = Direct.DOWN;
                    } else {
                        j++;
                    }
                    break;
                case DOWN:
                    if (i == bottom) {
                        j--;
                        right = j;
                        direct = Direct.LEFT;
                    } else {
                        i++;
                    }
                    break;
                case LEFT:
                    if (j == left) {
                        i--;
                        bottom = i;
                        direct = Direct.UP;
                    } else {
                        j--;
                    }
                    break;
                case UP:
                    if (i == top) {
                        j++;
                        left = j;
                        direct = Direct.RIGHT;
                    } else {
                        i--;
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }
        return arr;
    }
}

enum Direct {
             LEFT, RIGHT, DOWN, UP;
}