package com.javarush.task.task19.task1909;

import java.io.*;
/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fWriter = new BufferedWriter(new FileWriter(reader.readLine()));

        reader.close();

        String data;
        while((data = fReader.readLine()) != null){
            data = data.replace('.', '!');
            fWriter.write(data);
        }

        fReader.close();
        fWriter.close();
    }
}
