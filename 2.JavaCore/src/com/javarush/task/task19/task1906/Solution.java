package com.javarush.task.task19.task1906;

import java.io.*;
/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());

        reader.close();

        int counter = 1, data;


        while(fileReader.ready()) {
            data = fileReader.read();

            if(counter % 2 == 0)
                fileWriter.write(data);

            counter++;
        }

        fileReader.close();
        fileWriter.close();
    }
}
