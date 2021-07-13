package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fStream = new FileInputStream(reader.readLine());

        int max = 0, data;

        while(fStream.available() > 0){
            data = fStream.read();

            if(data > max)
                max = data;
        }

        System.out.println(max);

        fStream.close();
        reader.close();
    }
}
