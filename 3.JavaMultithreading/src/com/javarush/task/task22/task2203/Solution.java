package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null)
            throw new TooShortStringException();

        int indexFirst = string.indexOf("\t");

        if(indexFirst == -1)
            throw new TooShortStringException();

        indexFirst++;

        int indexLast = string.indexOf("\t", indexFirst);

        if(indexLast == -1)
            throw new TooShortStringException();

        return string.substring(indexFirst, indexLast);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
