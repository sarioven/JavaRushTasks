package com.javarush.task.task26.task2603;

import java.util.Comparator;

/* 
Убежденному убеждать других не трудно
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... vararg) {
            comparators = vararg;
        }

        @Override
        public int compare(T o1, T o2) {
            int result;

            for(Comparator<T> comp : comparators) {
                result = comp.compare(o1, o2);

                if(result != 0)
                    return result;
            }

            return 0;
        }
    }
}
