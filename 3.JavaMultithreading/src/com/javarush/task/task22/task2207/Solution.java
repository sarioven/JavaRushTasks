package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fInput = new FileInputStream(reader.readLine());
        BufferedReader fReader = new BufferedReader(new InputStreamReader(fInput));

        String string = "";
        Set<Pair> set = new HashSet<>();
        String[] array;
        StringBuilder builder = new StringBuilder("");

        while ((string = fReader.readLine()) != null) {
            builder.append(string);
            builder.append(" ");
        }
        array = builder.toString().split(" ");

        for (int i = 0, j = array.length - 1; i < j; i++) {
            if(array[i].equals(""))
                continue;

            for (int k = i + 1, l = array.length; k < l; k++) {
                if(array[k].equals(""))
                    continue;

                builder = new StringBuilder(array[k]);
                builder.reverse();


                if (array[i].equals(builder.toString())) {
                    Pair pair = new Pair();
                    pair.first = array[i];
                    pair.second = array[k];

                    array[i] = "";
                    array[k] = "";

                    result.add(pair);
                    break;
                }
            }
        }

        for (Pair pair : result) {
            System.out.println(pair.toString());
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }
}
