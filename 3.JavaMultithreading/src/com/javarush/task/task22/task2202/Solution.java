package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервисJava."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        String[] array;
        String result = "";

        try {
            array = string.split(" ");

            for(int i=0; i < 4; i++) {
                result += array[i+1];

                if(i != 3)
                    result += " ";
            }
        }
        catch(Exception e)  {throw new TooShortStringException();}

        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
