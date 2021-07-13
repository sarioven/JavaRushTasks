package com.javarush.task.task18.task1824;

import java.io.*;
/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = "";
        FileInputStream fStream;

        try {
            while (true) {
                fileName = reader.readLine();

                fStream = new FileInputStream(fileName);
                fStream.close();
            }
        }
        catch(FileNotFoundException e) {
            System.out.println(fileName);
        }
    }
}
