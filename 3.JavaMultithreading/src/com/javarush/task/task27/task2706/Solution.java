package com.javarush.task.task27.task2706;

/* 
Убираем deadlock
*/

public class Solution {
    public void safeMethod(Object obj1, Object obj2) {
        int hash1 = obj1.hashCode();
        int hash2 = obj2.hashCode();

        Object max = hash1 > hash2 ? obj1 : obj2;
        Object min = hash1 < hash2 ? obj1 : obj2;

        synchronized (max) {
            longTimeMethod();
            synchronized (min) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}
