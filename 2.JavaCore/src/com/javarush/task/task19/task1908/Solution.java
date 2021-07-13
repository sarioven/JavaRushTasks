package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));

        reader.close();

        String data;
        int number = 0;

        while((data = fileReader.readLine()) != null) {
            for(String s : data.split(" ")) {
                try {
                    number = Integer.parseInt(s);
                }
                catch(Exception e) {continue;}

                fileWriter.write(number + " ");
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
