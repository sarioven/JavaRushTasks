package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        /*for(StackTraceElement element : e.getStackTrace())
            System.out.println(element.toString());*/

        //System.out.println(e.getCause());
        LinkedList<Throwable> list = new LinkedList<>();
        for (Throwable err = e; err != null; err = err.getCause()) {
            list.push(err);
        }

        for(Throwable thro : list)
            System.out.println(thro.toString());
    }

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();

                    throw new RuntimeException("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
            }
        };

        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();
    }
}
