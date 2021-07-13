package com.javarush.task.task18.task1819;

import java.io.*;
/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine(),
               file2 = reader.readLine();

        reader.close();

        FileInputStream fStream1 = new FileInputStream(file1);
        FileInputStream fStream2 = new FileInputStream(file2);

        byte[] f1Data, f2Data;
        f1Data = new byte[fStream1.available()];
        f2Data = new byte[fStream2.available()];

        fStream1.read(f1Data);
        fStream2.read(f2Data);

        fStream1.close();
        fStream2.close();

        FileOutputStream fStream = new FileOutputStream(file1);

        fStream.write(f2Data);
        fStream.write(f1Data);
        fStream.close();
    }
}
