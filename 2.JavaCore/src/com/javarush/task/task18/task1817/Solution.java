package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fStream = new FileInputStream(args[0]);
        int counterSpace = 0, counterSimbols = 0;

        while(fStream.available() > 0) {
            if((char)fStream.read() == ' ')
                counterSpace++;

            counterSimbols++;
        }

        fStream.close();

        System.out.println(String.format("%.2f", counterSpace / (counterSimbols*1.0)*100));
    }
}
