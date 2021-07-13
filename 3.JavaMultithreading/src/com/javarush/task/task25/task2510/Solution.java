package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/

public class Solution extends Thread {

    public Solution() {
        setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if(e.toString().contains("Error")) {
                    System.out.println("Нельзя дальше работать");
                }
                else  if(e.toString().contains("Exception")) {
                    System.out.println("Надо обработать");
                }
                else if(e.toString().contains("Throwable")) {
                    System.out.println("Поживем - увидим");
                }
            }
        });
    }

    public static void main(String[] args) {
    }
}
