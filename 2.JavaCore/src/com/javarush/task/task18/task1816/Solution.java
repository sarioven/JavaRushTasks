package com.javarush.task.task18.task1816;


/* 
Английские буквы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int counter = 0;
        char data;

        FileInputStream fStream = new FileInputStream(args[0]);

        while(fStream.available() > 0) {
            data = (char)fStream.read();
            if(alphabet.contains("" + data) || alphabet.contains("" + Character.toLowerCase(data)))
                counter++;
        }

        fStream.close();

        System.out.println(counter);
    }
}
