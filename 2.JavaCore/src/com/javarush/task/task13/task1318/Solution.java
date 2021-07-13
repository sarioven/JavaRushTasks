package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.*;
/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        FileInputStream file = new FileInputStream(reader.readLine());

        BufferedReader readerFile = new BufferedReader(new InputStreamReader(file));

        String text;

        while((text = readerFile.readLine()) != null)
            System.out.println(text);
        
        file.close();
        reader.close();
    }
}