package com.javarush.task.task18.task1818;

import java.io.*;
/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream fStream1 = new FileOutputStream(reader.readLine());
        FileInputStream fStream2 = new FileInputStream(reader.readLine());
        FileInputStream fStream3 = new FileInputStream(reader.readLine());

        reader.close();

        byte[] data = new byte[fStream2.available()];

        fStream2.read(data);
        fStream1.write(data);

        data = new byte[fStream3.available()];

        fStream3.read(data);
        fStream1.write(data);

        fStream1.close();
        fStream2.close();
        fStream3.close();
    }
}
