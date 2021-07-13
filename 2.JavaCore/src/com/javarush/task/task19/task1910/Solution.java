package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fWriter = new BufferedWriter(new FileWriter(reader.readLine()));

        reader.close();

        String data, newData = "";

        while((data = fReader.readLine()) != null) {
            for(char ch : data.toCharArray()) {
                if(Character.isAlphabetic(ch) || Character.isDigit(ch) || ch == ' ')
                newData += ch;
            }

            fWriter.write(newData);
            newData = "";
        }

        fReader.close();
        fWriter.close();
    }
}
