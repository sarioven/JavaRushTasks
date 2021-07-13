package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fStream = new FileInputStream(reader.readLine());

        char ch;
        int counter = 0;

        while(fStream.available() > 0) {
            ch = (char)fStream.read();

            if(ch == ',')
                counter++;
        }

        fStream.close();
        reader.close();

        System.out.println(counter);
    }
}
