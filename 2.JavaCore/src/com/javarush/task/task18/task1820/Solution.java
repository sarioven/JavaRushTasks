package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fStream1 = new FileInputStream(reader.readLine());
        FileOutputStream fStream2 = new FileOutputStream(reader.readLine());

        reader.close();

        BufferedReader fReader = new BufferedReader(new InputStreamReader(fStream1));

        String s;
        while((s = fReader.readLine()) != null) {
            for(String item : s.split(" "))
                fStream2.write((Math.round(Double.parseDouble(item)) + " ").getBytes());
        }

        fStream1.close();
        fStream2.close();
    }
}
