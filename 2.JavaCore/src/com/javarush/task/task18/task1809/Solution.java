package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.*;
/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fStream1 = new FileInputStream(reader.readLine());
        FileOutputStream fStream2 = new FileOutputStream(reader.readLine());

        byte[] buffer;

        if(fStream1.available() > 0) {
            buffer = new byte[fStream1.available()];
        }
        else {
            fStream1.close();
            fStream2.close();
            reader.close();

            return;
        }

        fStream1.read(buffer);

        int size = buffer.length/2;
        byte data;

        for(int i=0; i < size; i++) {
            data = buffer[buffer.length-1-i];
            buffer[buffer.length-1-i] = buffer[i];
            buffer[i] = data;
        }

        fStream2.write(buffer);

        fStream1.close();
        fStream2.close();
        reader.close();
    }
}
