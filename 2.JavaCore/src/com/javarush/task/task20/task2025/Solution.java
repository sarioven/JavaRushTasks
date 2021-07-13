package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/

public class Solution {
    /*public static long[] getNumbers(long N) {
        long[] result = null;
        List<Long> resultList = new ArrayList<>();

        char[] number;

        int pow;
        long summ;

        for(long count = 0; count < N; count++) {
            number = ("" + count).toCharArray();
            pow = number.length;

            summ = 0;

            for(int i=0; i < pow; i++) {
                summ += Math.pow((number[i] - '0'), pow);
            }

            if(summ == count)
                resultList.add(count);
        }

        result = new long[resultList.size()];

        for(int i=0, j = resultList.size(); i < j; i++)
            result[i] = resultList.get(i);

        return result;
    }*/

    private static long[][] pows;

    private static void genPows(int N) {
        if (N > 20) throw new IllegalArgumentException();
        pows = new long[10][N + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }
    }

    private static boolean check(long i) {
        long powSum = 0;
        long x = i;
        int N = ((int) Math.log10(x)) + 1;
        do {
            int mod = (int) x % 10;
            powSum += pows[mod][N];
            x = x / 10;
        } while (x != 0);
        return powSum == i;
    }

    public static List<Long> getNumbers(int maxN) {
        if (maxN >= 20) throw new IllegalArgumentException();
        List<Long> results = new ArrayList<>();
        genPows(maxN);
        long limit = (long) Math.pow(10, maxN);
        for (long i = 1; i < limit; i++) {
            if (check(i)) results.add(i);
        }
        return results;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(20)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
