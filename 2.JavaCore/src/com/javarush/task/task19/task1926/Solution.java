package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fReader = new FileReader(reader.readLine());
        reader.close();
        BufferedReader fBReader = new BufferedReader(fReader);

        String buffer;
        char[] data;
        char aBuffer;
        while((buffer = fBReader.readLine()) != null) {
            data = buffer.toCharArray();

            for(int i=0; i < data.length/2; i++) {
                aBuffer = data[data.length-1-i];
                data[data.length-1-i] = data[i];
                data[i] = aBuffer;
            }

            System.out.println(data);
        }

        fBReader.close();
    }
}
