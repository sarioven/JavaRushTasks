package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;

        for(int i=0, j = a.length; i < j; i++) {
            for(int k=0, l = a[0].length; k < l; k++) {
                if (a[i][k] == 0)
                    continue;

                count++;

                for (int ii = i, jj = a.length; ii < jj; ii++) {
                    if (a[ii][k] == 0)
                        break;

                    for (int kk = k, ll = a[0].length; kk < ll; kk++) {
                        if (a[ii][kk] == 0)
                            break;

                        a[ii][kk] = 0;
                    }
                }
            }
        }

        return count;
    }
}
