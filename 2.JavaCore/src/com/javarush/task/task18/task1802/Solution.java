package com.javarush.task.task18.task1802;

import java.io.*;

/*
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fStream = new FileInputStream(reader.readLine());

        int min = Integer.MAX_VALUE, data;

        while(fStream.available() > 0) {
            data = fStream.read();

            if(data < min)
                min = data;
        }

        fStream.close();
        reader.close();

        System.out.println(min);
    }
}
